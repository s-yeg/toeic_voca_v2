package com.yeji.toeic_vova.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;
import com.yeji.toeic_vova.entity.User;
import org.springframework.web.bind.annotation.PostMapping;
import com.yeji.toeic_vova.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {

        session.invalidate();

        return "redirect:/login";
    }

    @PostMapping("/signup")
    public String signup(User user, Model model) {

        String username = user.getUsername() == null ? "" : user.getUsername().trim();
        String password = user.getPassword() == null ? "" : user.getPassword().trim();

        if (username.isEmpty() || password.isEmpty()) {
            model.addAttribute("error", "아이디와 비밀번호를 입력하세요.");
            return "signup";
        }

        if (userRepository.existsByUsername(username)) {
            model.addAttribute("error", "이미 있는 아이디입니다.");
            return "signup";
        }

        user.setUsername(username);
        user.setPassword(password);

        userRepository.save(user);

        return "redirect:/";
    }
    @PostMapping("/login")
    public String login(User user, Model model, HttpSession session) {

        User findUser = userRepository.findByUsername(user.getUsername());

        if (findUser == null) {
            model.addAttribute("error", "아이디 또는 비밀번호가 틀렸습니다.");
            return "login";
        }

        if (!findUser.getPassword().equals(user.getPassword())) {
            model.addAttribute("error", "아이디 또는 비밀번호가 틀렸습니다.");
            return "login";
        }

        session.setAttribute("loginUser", findUser);
        return "redirect:/";
    }

}