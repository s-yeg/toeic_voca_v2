import re
import pdfplumber

PDF_FILE = "700+voca.pdf"
OUTPUT_FILE = "words.sql"

def clean_word(text):
    text = re.sub(r"\[.*?\]", "", text)  # 발음기호 제거
    text = text.replace("미 ", "").replace("영 ", "")
    return text.strip()

def sql_escape(text):
    return text.replace("'", "''")

rows = []

with pdfplumber.open(PDF_FILE) as pdf:
    for page in pdf.pages:
        text = page.extract_text(x_tolerance=1, y_tolerance=3)

        if not text:
            continue

        day_match = re.search(r"DAY\s*(\d{2})", text)
        if not day_match:
            continue

        day_no = int(day_match.group(1))

        lines = text.splitlines()

        for line in lines:
            # 예: 01 agenda[발음] 안건, 의제 11 hand out 나누어 주다
            matches = re.findall(r"(\d{2})\s+(.+?)(?=\s+\d{2}\s+|$)", line)

            for num, item in matches:
                num_int = int(num)

                # 1~20 단어 번호만 사용
                if not (1 <= num_int <= 20):
                    continue

                # 영어 단어 + 한국어 뜻 분리
                m = re.match(r"(.+?)\s+([가-힣~,\(\)ㆍ·\s]+)$", item.strip())
                if not m:
                    continue

                word = clean_word(m.group(1))
                meaning = m.group(2).strip()

                # 예문/퀴즈 같은 것 제외
                if len(word) > 80 or len(meaning) > 100:
                    continue

                rows.append((day_no, word, meaning))

with open(OUTPUT_FILE, "w", encoding="utf-8") as f:
    f.write("USE toeic_app;\n\n")
    f.write("INSERT INTO words(day_no, word, meaning)\nVALUES\n")

    values = []
    for day_no, word, meaning in rows:
        values.append(
            f"({day_no}, '{sql_escape(word)}', '{sql_escape(meaning)}')"
        )

    f.write(",\n".join(values))
    f.write(";\n")

print(f"완료! {OUTPUT_FILE} 생성됨")
print(f"추출된 단어 수: {len(rows)}")