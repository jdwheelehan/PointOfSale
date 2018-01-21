package Launchcode.project.PointOfSale.controllers;

import Launchcode.project.PointOfSale.models.Item;
import Launchcode.project.PointOfSale.models.data.ItemDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.DecimalFormat;
import java.util.ArrayList;

@Controller
@RequestMapping("sales")
public class SalesController {

    @Autowired
    ItemDao itemDao;

    private ArrayList<Item> items = new ArrayList<>();

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model){
        DecimalFormat df = new DecimalFormat("0.##");
        Double tax = 8.00/100;
        Double subtotal = 0.00;
        for (Item i : items){
            subtotal = subtotal + i.getPrice();
        }
        double total = subtotal+(subtotal*tax);
        model.addAttribute("title", "sales");
        model.addAttribute("items", items);
        model.addAttribute("subtotal", df.format(subtotal));
        model.addAttribute("tax", df.format(subtotal*tax));
        model.addAttribute("total", df.format(total));

        return "sales/index";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String processIndexForm(@RequestParam Integer sku, Model model) {


        if (itemDao.exists(sku)) {
            Item newItem = itemDao.findOne(sku);
            newItem.setQuantity((newItem.getQuantity()) - 1);
            items.add(newItem);
            itemDao.save(newItem);
            return "redirect:sales";
        } else {

            return "redirect:";
        }
    }

    }
