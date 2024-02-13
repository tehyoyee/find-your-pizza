package com.pizzaTest.service;

public class ServeyService{

    public String CalulateMBTI(int[] selectQuestion){

        int calculateNumber;
        String mbti, mbti1= null, mbti2= null, mbti3= null, mbti4 = null;

        for(int i=0; i<4; i++) {

            calculateNumber = selectQuestion[3*i]+selectQuestion[3*i+1]+selectQuestion[3*i+2];

            if (i==0){
                if (calculateNumber >1){
                    mbti1 = "I";
                }else{
                    mbti1 = "E";
                }
            }else if(i==1){
                if (calculateNumber >1){
                    mbti2 = "N";
                }else{
                    mbti2 = "S";
                }
            }else if(i==2){
                if (calculateNumber >1){
                    mbti3 = "F";
                }else{
                    mbti3 = "T";
                }
            }else {
                if (calculateNumber >1){
                    mbti4 = "P";
                }else{
                    mbti4 = "J";
                }
            }
        }
            mbti = mbti1 + mbti2 + mbti3 + mbti4;
            return mbti;
    }
}