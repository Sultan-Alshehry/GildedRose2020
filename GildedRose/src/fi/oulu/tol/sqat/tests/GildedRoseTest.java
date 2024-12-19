package fi.oulu.tol.sqat.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import fi.oulu.tol.sqat.GildedRose;
import fi.oulu.tol.sqat.Item;

public class GildedRoseTest {

	@Test
	public void testTheTruth() {
		assertTrue(true);
	}
	
	@Test
	public void exampleTest() {
		//create an inn, add an item, and simulate one day
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("+5 Dexterity Vest", 10, 20));
		inn.oneDay();
		
		//access a list of items, get the quality of the one set
		List<Item> items = inn.getItems();
		int quality = items.get(0).getQuality();
		
		//assert quality has decreased by one
		assertEquals("Failed quality for Dexterity Vest", 19, quality);
	}
	

	
	@Test
	public void brieAgingTest() {
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Aged Brie", 2, 0));
		inn.oneDay();
		inn.oneDay();
		inn.oneDay();
		inn.oneDay();
		
		List<Item> items = inn.getItems();
		int quality = items.get(0).getQuality();
		assertEquals("Failed quality for Aged Brie", 6, quality);
	}
	
	@Test
	public void backstagePassesTest() {
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Backstage passes to a TAFKAL80ETC concert", 11, 20));
		inn.oneDay();
		List<Item> items = inn.getItems();
		int quality = items.get(0).getQuality();
		assertEquals("Failed quality for Backstage Passes", 21, quality);
	}
	
	@Test
	public void backstagePassesQualityIncrease1Test() {
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20));
		inn.oneDay();
		List<Item> items = inn.getItems();
		int quality = items.get(0).getQuality();
		assertEquals("Failed quality for Backstage Passes Quality Increase 1", 22, quality);
	}
	
	@Test
	public void backstagePassesQualityIsAlreadyMaxPreTest() {
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49));
		inn.oneDay();
		List<Item> items = inn.getItems();
		int quality = items.get(0).getQuality();
		assertEquals("Failed quality for Backstage Passes Quality Is Already Max 1", 50, quality);
	}
	
	@Test
	public void backstagePassesQualityIsAlreadyMax1Test() {
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Backstage passes to a TAFKAL80ETC concert", 10, 50));
		inn.oneDay();
		List<Item> items = inn.getItems();
		int quality = items.get(0).getQuality();
		assertEquals("Failed quality for Backstage Passes Quality Is Already Max 1", 50, quality);
	}
	
	@Test
	public void backstagePassesQualityIncrease2Test() {
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20));
		inn.oneDay();
		List<Item> items = inn.getItems();
		int quality = items.get(0).getQuality();
		assertEquals("Failed quality for Backstage Passes Quality Increase 2", 23, quality);
	}
	
	@Test
	public void backstagePassesQualityIsAlreadyMax2Test() {
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Backstage passes to a TAFKAL80ETC concert", 5, 50));
		inn.oneDay();
		List<Item> items = inn.getItems();
		int quality = items.get(0).getQuality();
		assertEquals("Failed quality for Backstage Passes Quality Is Already Max 1", 50, quality);
	}
	
	@Test
	public void backstagePassesConcertEndTest() {
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Backstage passes to a TAFKAL80ETC concert", -1, 20));
		inn.oneDay();
		List<Item> items = inn.getItems();
		int quality = items.get(0).getQuality();
		assertEquals("Failed quality for Backstage Passes concert end", 0, quality);
	}
	
	@Test
	public void sulfurasQualitiyUpdateTest() {
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		inn.oneDay();
		List<Item> items = inn.getItems();
		int quality = items.get(0).getQuality();
		assertEquals("Failed quality for Sulfuras", 80, quality);
	}
	
	@Test
	public void expiredSulfurasQualitiyUpdateTest() {
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Sulfuras, Hand of Ragnaros", -1, 80));
		inn.oneDay();
		List<Item> items = inn.getItems();
		int quality = items.get(0).getQuality();
		assertEquals("Failed quality for Sulfuras", 80, quality);
	}
	

	
	@Test
	public void spoiledManaCakeTest() {
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Conjured Mana Cake", 3, 6));
		inn.oneDay();
		inn.oneDay();
		inn.oneDay();
		inn.oneDay();
		inn.oneDay();

		List<Item> items = inn.getItems();
		int quality = items.get(0).getQuality();
		assertEquals("Failed quality for spoiled Mana Cake", 0, quality);
	}
	
	@Test
	public void maxQualitiyBrieTest() {
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Aged Brie", 0, 49));
		inn.oneDay();
		inn.oneDay();
		
		List<Item> items = inn.getItems();
		int quality = items.get(0).getQuality();
		assertEquals("Failed quality for max quality Brie", 50, quality);
	}
	
	
	
	@Test
	public void testMainMethod() {
	    GildedRose inn = new GildedRose();
	    GildedRose.main(new String[] {});
	    List<Item> items = inn.getItems();

	    assertEquals("First item name mismatch", "+5 Dexterity Vest", items.get(0).getName());
	    assertEquals("First item sellIn mismatch", 9, items.get(0).getSellIn());
	    assertEquals("First item quality mismatch", 19, items.get(0).getQuality());
	    assertEquals("Last item name mismatch", "Conjured Mana Cake", items.get(5).getName());
	    assertEquals("Last item sellIn mismatch", 2, items.get(5).getSellIn());
	    assertEquals("Last item quality mismatch", 5, items.get(5).getQuality());
	}
	
	@Test
	public void loopSkipTest() {
	    GildedRose inn = new GildedRose();
	    inn.oneDay();
	    assertTrue(inn.getItems().isEmpty());
	}

	@Test
	public void loop1Test() {
	    GildedRose inn = new GildedRose();
		inn.setItem(new Item("Backstage passes to a TAFKAL80ETC concert", 11, 20));
	    inn.oneDay();

		List<Item> items = inn.getItems();

		String name = items.get(0).getName();
	    assertEquals("loop 1 test fail", name, "Backstage passes to a TAFKAL80ETC concert");
	}
	
	@Test
	public void loop2Test() {
	    GildedRose inn = new GildedRose();
		inn.setItem(new Item("Backstage passes to a TAFKAL80ETC concert", 11, 20));
		inn.setItem(new Item("Backstage passes to a TAFKAL80ETC concert", 11, 20));
	    inn.oneDay();

		List<Item> items = inn.getItems();

		String name1 = items.get(0).getName();
		String name2 = items.get(1).getName();

	    assertEquals("loop 2 test fail", name1, "Backstage passes to a TAFKAL80ETC concert");
	    assertEquals("loop 2 test fail", name2, "Backstage passes to a TAFKAL80ETC concert");

	}
	
	@Test
	public void loop5Test() {
	    GildedRose inn = new GildedRose();
		inn.setItem(new Item("Backstage passes to a TAFKAL80ETC concert", 11, 20));
		inn.setItem(new Item("Backstage passes to a TAFKAL80ETC concert", 11, 20));
		inn.setItem(new Item("Backstage passes to a TAFKAL80ETC concert", 11, 20));
		inn.setItem(new Item("Backstage passes to a TAFKAL80ETC concert", 11, 20));
		inn.setItem(new Item("Backstage passes to a TAFKAL80ETC concert", 11, 20));

	    inn.oneDay();

		List<Item> items = inn.getItems();

		String name1 = items.get(0).getName();
		String name2 = items.get(1).getName();
		String name3 = items.get(2).getName();
		String name4 = items.get(3).getName();
		String name5 = items.get(4).getName();

	    assertEquals("loop 5 test fail", name1, "Backstage passes to a TAFKAL80ETC concert");
	    assertEquals("loop 5 test fail", name2, "Backstage passes to a TAFKAL80ETC concert");
	    assertEquals("loop 5 test fail", name3, "Backstage passes to a TAFKAL80ETC concert");
	    assertEquals("loop 5 test fail", name4, "Backstage passes to a TAFKAL80ETC concert");
	    assertEquals("loop 5 test fail", name5, "Backstage passes to a TAFKAL80ETC concert");
	}
	
	@Test
	public void loop50Test() {
		GildedRose inn = new GildedRose();
		for (int i = 0; i < 50; i++) {
			inn.setItem(new Item("+" + i + " Dexterity Vest", 10, 20));
		}
		inn.oneDay();
		
		List<Item> items = inn.getItems();
		for (int i = 0; i < 50; i++) {
			int quality = items.get(i).getQuality();
			assertEquals("Failed quality for Dexterity Vest" + i, 19, quality);
		}
	}
}
