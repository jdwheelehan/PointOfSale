package Launchcode.project.PointOfSale.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
@RequestMapping("encode")
public class EncodeController {


    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model){

        return "encode/index";
    }


    @RequestMapping(value = "", method = RequestMethod.POST)
    public String processIndex(@RequestParam String subject, Model model){
        ArrayList<Character> charList = new ArrayList<>();
        ArrayList<Integer> numList = new ArrayList<>();
        for(int i = 0; i<subject.length();i++){
            charList.add(subject.charAt(i));
        }
        for (int i = 0; i <subject.length(); i++){
            Character singleChar = charList.get(i);
            numList.add(Character.getNumericValue(singleChar));
        }

        Integer sum = 0;
        for(Integer d : numList){
            sum += d;}

        Integer encodedValue = sum*(Character.getNumericValue(subject.charAt(3)));


        model.addAttribute("encode", encodedValue);
        return "encode/index";
    }


}
