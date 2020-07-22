package com.example.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pojo.Inventry;
import com.example.service.InventryService;



@RestController
@RequestMapping("/Inventory")
public class InventryController {
	
		@Autowired
		private InventryService inventoryservice;
		
		@RequestMapping("/getAllInventories")
		public List<Inventry> getAllInventory() {
			return inventoryservice.allInventories();
		}
		
		
		@PostMapping("/saveFare")
		public Inventry saveFare(@RequestBody Inventry inv) {
			return inventoryservice.saveFare(inv);
		}

		@PutMapping("/updateInventory/{fareId}")
		public Inventry updateInventoryById(@RequestBody Inventry inv, @PathVariable("id") Integer inventoryId) {
			return inventoryservice.updateInventory(inv, inventoryId);

		}

		@DeleteMapping("/deleteInventory/{inventoryId}")
		public int deleteInventory(@PathVariable("inventoryId") Integer inventoryId) {
			return inventoryservice.deleteInventory(inventoryId);
		}

		@GetMapping("/findOneInAll/{inventoryId}")
		public Optional<Inventry> findInventoryInAll(@PathVariable("fareId") Integer inventoryId) {
			return inventoryservice.findFareById(inventoryId);

		}


}
