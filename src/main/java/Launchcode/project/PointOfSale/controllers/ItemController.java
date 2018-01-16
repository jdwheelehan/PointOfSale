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
import java.util.List;

@Controller
@RequestMapping("inventory")
public class ItemController {

    @Autowired
    ItemDao itemDao;

    @RequestMapping(value = "")
    public String index(Model model){

        model.addAttribute("items", itemDao.findAll());
        model.addAttribute("title", "My Stock");

        return "inventory/index";
    }

    @RequestMapping(value = "receiving", method = RequestMethod.GET)
    public String displayRecievingForm(Model model){
        model.addAttribute("title", "Receiving");
        model.addAttribute("items", itemDao.findAll());
        return "inventory/receiving";
    }

    @RequestMapping(value = "receiving", method = RequestMethod.POST)
    public String processRecievinForm(@RequestParam Integer sku, @RequestParam Integer qty,  Model model){

        if (itemDao.exists(sku)){
            Item newItem = itemDao.findOne(sku);
            newItem.setQuantity(newItem.getQuantity()+ qty);
            itemDao.save(newItem);
            return "redirect:receiving";
        }else{

            return "redirect:addstock";}




    }


    @RequestMapping(value = "addstock", method = RequestMethod.GET)
    public String displayNewStockForm(Model model){
        model.addAttribute("title", "Add Stock");
        return "inventory/addstock";
    }

    @RequestMapping(value = "addstock", method = RequestMethod.POST)
    public String processNewStockForm(@RequestParam Integer sku, @RequestParam String name, @RequestParam Integer qty ,
                                      @RequestParam Double price,  Model model){



        Item newItem = new Item(sku, name, qty, price);
        itemDao.save(newItem);



        return "redirect:receiving";
    }


}
