package Launchcode.project.PointOfSale.controllers;

import Launchcode.project.PointOfSale.models.Item;
import Launchcode.project.PointOfSale.models.data.ItemDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
@RequestMapping("search")
public class SearchController {

    @Autowired
    ItemDao itemDao;

    private ArrayList<Item> searchResults;


    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model){

        model.addAttribute("results", searchResults);
        model.addAttribute("title", "Search");

        return "search/index";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String processIndex(@RequestParam String searchTerm, Model model){

        searchResults = new ArrayList<>();

        for (Item i : itemDao.findAll()){
            if (i.getName().toLowerCase().contains(searchTerm.toLowerCase())){
                searchResults.add(i);
            }
        }


        return "redirect:";
    }

}
