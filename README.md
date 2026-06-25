<div align="center">

# 📚 TOEIC VOCA V1

### TOEIC Vocabulary Learning Web Application

> Spring Boot와 MySQL을 활용한 토익 단어 학습 웹 애플리케이션 **[ Ver.1 ]**

<br>

![Java](https://img.shields.io/badge/Java-17-orange?style=for-the-badge)
![Spring Boot](https://img.shields.io/badge/SpringBoot-3.x-success?style=for-the-badge)
![MySQL](https://img.shields.io/badge/MySQL-8.0-blue?style=for-the-badge)
![JPA](https://img.shields.io/badge/Spring_Data_JPA-Hibernate-success?style=for-the-badge)
![Thymeleaf](https://img.shields.io/badge/Thymeleaf-3.1-green?style=for-the-badge)
![HTML5](https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge)
![CSS3](https://img.shields.io/badge/CSS3-1572B6?style=for-the-badge)
![JavaScript](https://img.shields.io/badge/JavaScript-F7DF1E?style=for-the-badge)

</div>

---

# 📖 Project Overview

TOEIC 단어를 **Day별로 학습**하고 객관식 퀴즈를 통해 학습 내용을 확인할 수 있는 웹 애플리케이션입니다.

오답노트를 이용한 반복 학습 기능을 제공하며, Spring Boot와 MySQL을 활용하여 구현하였습니다.

---

# ✨ Features

| 기능 | 설명 |
|------|------|
| 📅 Day 선택 | Day별 단어 학습 |
| 📖 Words | 선택한 Day 단어 조회 |
| 📝 Quiz | 객관식 단어 퀴즈 |
| 📒 Review | 틀린 단어 복습 |
| 💾 MySQL | 단어 데이터 관리 |

---

# 🛠 Tech Stack

| Category | Technology |
|-----------|------------|
| Backend | Java 17, Spring Boot |
| Database | MySQL |
| ORM | Spring Data JPA |
| Template | Thymeleaf |
| Frontend | HTML, CSS, JavaScript |
| Tool | Git, GitHub, IntelliJ IDEA |

---

# 📷 Screen

<table>
<tr>
<td align="center">
<b>HOME</b><br>
<img src="screenshots/home.png" width="430">
</td>

<td align="center">
<b>DAY</b><br>
<img src="screenshots/day.png" width="430">
</td>
</tr>

<tr>
<td align="center">
<b>WORDS</b><br>
<img src="screenshots/words.png" width="430">
</td>

<td align="center">
<b>QUIZ</b><br>
<img src="screenshots/quiz.png" width="430">
</td>
</tr>
</table>

---

# 🔄 Application Flow

```text
HOME
   │
   ▼
DAY Selection
   │
   ├────────► WORDS
   │
   ├────────► QUIZ
   │
   ▼
REVIEW
```

---

# 💾 Database

| Table | Description |
|--------|-------------|
| words | 토익 단어 데이터 |
| wrong_words | 오답노트 데이터 |

---

# ⚠ Copyright

저작권 이슈를 고려하여

- 실제 토익 단어 데이터
- 원본 PDF

는 GitHub 저장소에 포함하지 않았습니다.

공개 저장소에는 프로젝트 소스코드와 화면 캡처 이미지만 포함되어 있습니다.
(해커스 보카 참고)

---

# 🚀 Future Plan

### Version 2

- 회원가입
- 로그인
- Session 관리
- 사용자별 오답노트
- 사용자별 학습기록
- 점수 저장 기능

---

<div align="center">

Made with 💜 by **손예지**

</div>
