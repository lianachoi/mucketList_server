package com.liana.DWShop.item.controller;

import com.liana.DWShop.item.controller.exception.idNotFoundException;
import com.liana.DWShop.item.controller.repository.ItemRepository;
import com.liana.DWShop.item.controller.repository.OptionRepository;
import com.liana.DWShop.item.model.Item;
import com.liana.DWShop.item.model.Option;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/items")
@RequiredArgsConstructor
public class ItemController {
    private final ItemRepository itemRepository;
    private final OptionRepository optionRepository;

    // get all
    @GetMapping
    public List<Item> getAllItems()
    {
        return itemRepository.findAll();
    }

    // get one by id
    @GetMapping("/{id}")
    public ResponseEntity<List<Item>> getOneById(@PathVariable Long id) {
        List<Item> item = itemRepository.findById(id);
        if(item==null)
        {
            throw new idNotFoundException();
        }
        return ResponseEntity.ok(item);
    }

    // get one by id
    @GetMapping("/{id}/options")
    public ResponseEntity<List<Option>> getOptionById(@PathVariable Long id) {
        List<Option> option = optionRepository.findById(id);
        if(option==null)
        {
            throw new idNotFoundException();
        }
        return ResponseEntity.ok(option);
    }
}
