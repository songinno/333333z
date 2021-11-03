package com.spring.mvc.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

//역할: 브라우저의 요청을 처리
@Controller
@Log4j2 //로그를 만들어주는 기능
public class BasicController {

    //요청 처리 메서드
//    @RequestMapping(value = "/req/hello", method = RequestMethod.GET)
    @GetMapping("/req/hello")
    public String hello() {
        //비즈니스 로직
        System.out.println("안녕안녕 hello hello");

        //화면 연결 - 2가지 방법
        /*
           1. redirect - 재요청
           2. forward  - 단순한 파일열기
         */
        //forward시에는 열어야 할 jsp의 경로를 문자열로 입력
        return "test";
//        return "redirect:/s-login-form";
    }

    // 사용자의 요청 URI : /req/ex
    // 응답시에 views폴더 아래에 req_ex폴더 아래에 있는 v1.jsp를 열어야함
    @GetMapping("/req/ex")
    public String ex() {
        return "req_ex/v1";
    }

    @GetMapping("/req/v1")
    public String v1() {
        log.info("/req/v1 GET!");
        return "req_ex/v1";
    }

    //요청파라미터 받기: 클라이언트에서 서버로 전송된 데이터
    // 생김새 예시) www.abc.com/req/v1?pet=puppy&kind=bulldog

    //1. HttpServletRequest 객체 활용하기
    @PostMapping
    public String v1Post(HttpServletRequest request) {
        log.info("/req/v1 POST!");
        String petName = request.getParameter("pet");
        String age = request.getParameter("age");
        int ageNum = Integer.parseInt(age);

        log.info("선택한 동물: " + petName);
        log.info(petName + "의 내년 나이는" + (ageNum + 1) + "살입니다.");
        return "req_ex/v1";
        //이 방법의 단점: 리턴이 String -> 숫자 쓸때 불편함.
    }

    //2. @RequestParam 이용하기
    @PostMapping("/req/v2")
    public String v2(String pet, int age) { //(@RequestParam String pet, int age) -> @RequestParam가 생략되어있음.
        //*주의점 html 에서 name이랑 매개변수 이름이랑 똑같아야함.
        //*혹시 일치 못시키는 경우(지역변수랑 겹칠때)는 -> @RequestParam("pet") String pet1
        log.info(String.format("%s의 작년 나이는 %d살입니다.", pet, age-1));
        return "req_ex/v1";
    }

    //근데 받을 데이터가 많아지면?
    // => 3. 커맨드 객체 확용하기 (Pet 클래스 추가)
    @PostMapping("/req/v3")
    public String v3(Pet petInfo) {
        log.info(petInfo);

        return "req_ex/v1";
    }
    //이제 정보를 보내면, 메세지를 써서 돌려주고싶음.

    //=============== 화면(view)으로 서버데이터 보내기==================//
    //서버에서 클라이언트화면으로 데이터를 보낼 땐 Model이라는 객체를 활용합니다.
    @GetMapping("/req/v4")
    public String v4(Model model) {
        //랜덤으로 음식 이름을 보내기
        String[] foods = {"짜장면", "볶음밥", "돈까스", "삼겹살", "햄버거"};
        int rn = (int) (Math.random() * foods.length);
        model.addAttribute("f", foods[rn]); //${} 에다가 넣음.
//        model.addAttribute("foods", Arrays.toString(foods));
        model.addAttribute("foods", foods);
        // 이렇게 보내면 서버가 클라이언트한테 배열을 보낸게 아니라 문자 열을 보낸거.

        return "req_ex/result";
    }

    @GetMapping("/req/v3")
    public String v5(Pet pet, Model model) {
        String petName = pet.getPet();
        int petAge = pet.getAge();
        String master = pet.getMaster();
        String gender = pet.getGender();
        String[] hobby = pet.getHobby();

        model.addAttribute("petName", petName);
        model.addAttribute("petAge", petAge);
        model.addAttribute("master", master);
        model.addAttribute("gender", gender);
        model.addAttribute("hobby", hobby);

        return "req_ex/pet_info";
    }






}
