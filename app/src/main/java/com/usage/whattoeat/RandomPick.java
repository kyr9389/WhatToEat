package com.usage.whattoeat;

import java.util.Random;

public class RandomPick {

    public String getRandTestString() {

        String RandomNames[] = {"나리네", "맘스터치", "버거킹", "후라이드 참 잘하는 집", "호식이 두마리 치킨", "용감한 떡볶이", "호야네", "소문날라", "신카츠", "도야지",
                                "네코정", "맥도날드", "밥은", "쪼매 매운 떡볶이", "삐삐핵볶이", "육쌈냉면", "우동 한그릇", "옐로 어니언", "버거 투 버거", "진국", "도쿄식탁",
                                "닛본우동 생 돈까스", "후레쉬팩토리스테이크", "스시락", "60계치킨", "노랑통닭", "BBQ", "깻잎두마리칩킨", "네네치킨", "또봉이통닭", "내가찜한닭",
                                "지지고", "레젼드피자", "만스피자", "피자헤븐", "7번가피자", "피자알볼로", "미스터피자", "피자에땅", "용문각", "공덕관", "남선반점", "스시류",
                                "색다른 탕수육", "서울대반점", "오봉족발", "세겹먹는날", "칼짚통삼겹살", "오븐에 빠진 닭", "써브웨이", "화적단", "맛닭꼬", "수제왕돈까스",
                                "옹기종기쌈밥", "김밥친구라면", "후원", "피자굽는언니", "뽕신", "전설의짬뽕"};

        Random oRandom = new Random();
        int randNum = oRandom.nextInt(RandomNames.length);

        return RandomNames[randNum];
    }
}