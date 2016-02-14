package org.apollo.game.model.inv;

import org.apollo.cache.def.ItemDefinition;
import org.apollo.cache.def.ObjectDefinition;
import org.apollo.game.model.Item;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ObjectDefinition.class,ItemDefinition.class})

public class InventoryTest {

	Inventory inventory;
	Inventory stackNeverInventory;
	Inventory stackableItemInventory;

	@Before
	public void setup() {
		mockStatic(ItemDefinition.class);
		inventory = new Inventory(28, Inventory.StackMode.STACK_ALWAYS);
		stackNeverInventory = new Inventory(13, Inventory.StackMode.STACK_NEVER);
		stackableItemInventory = new Inventory(15, Inventory.StackMode.STACK_STACKABLE_ITEMS);
	}

	/*
	Testing method add with different parameters
	 */
	@Test
	public void addTest(){
		inventory.add(4151,1);
		assertTrue(inventory.contains(4151));
		inventory.add(4152);
		assertTrue(inventory.contains(4152));
		Item item= new Item(4153,1);
		inventory.add(item);
		assertTrue(inventory.contains(4153));
	}

	@Test
	public void clearTest(){
		inventory.set(1, new Item(4151, 1));
		assertTrue(inventory.contains(4151));
		inventory.clear();
		assertTrue(!(inventory.contains(4551)));
	}

	@Test
	public void getAmountTest(){
		assertEquals(inventory.getAmount(5000),0);
		inventory.set(1, new Item(5000,3));
		assertEquals(inventory.getAmount(5000),3);
		inventory.add(new Item(5000,3));
		assertEquals(inventory.getAmount(5000),6);
	}

	@Test
	public void removeTest(){
		ItemDefinition definition;

		inventory.set(1, new Item(5000,3));
		inventory.remove(5000,2);
		assertEquals(inventory.getAmount(5000),1);

		stackNeverInventory.set(1, new Item(1234));
		stackNeverInventory.remove(1234);
		assertEquals(stackNeverInventory.getAmount(1234),0);

		Item item= new Item(4153,1);
		inventory.add(item);
		inventory.remove(item);
		assertEquals(inventory.getAmount(1453),0);


		/*TODO test when the inventory is an STACK_STACKABLE_ITEMS inventory */
	}


	@Test
	public void removeSlotTest(){
		inventory.set(1, new Item(5000,3));
		inventory.removeSlot(1,2);
		assertEquals(inventory.getAmount(5000),1);
	}

	@Test
	public void resetTest(){
		inventory.set(1, new Item(5000,3));
		inventory.reset(1);
		assertEquals(inventory.slotOf(5000),-1);
		assertEquals(inventory.get(1),null);
	}

	@Test
	public void setTest(){
		assertEquals(inventory.get(1),null);
		Item item= new Item(4153,1);
		inventory.set(1, item);
		assertEquals(inventory.get(1),item);
		inventory.set(1, null);
		assertEquals(inventory.get(1),null);
	}

	@Test
	public void shiftTest(){
		Item item= new Item(4153,1);
		Item item2= new Item(4154,1);
		Item item3= new Item(4155,1);
		inventory.set(5, item);
		inventory.set(6, item2);
		inventory.set(9, item3);
		inventory.shift();
		assertEquals(inventory.get(0),item);
		assertEquals(inventory.get(1),item2);
		assertEquals(inventory.get(2),item3);
	}

	@Test
	public void slotOfTest(){
		Item item= new Item(4153,1);
		inventory.set(1, item);
		assertEquals(inventory.slotOf(4153),1);
		assertEquals(inventory.slotOf(5000),-1);
	}


	@Test
	public void swapTest(){
		Item item= new Item(4153,1);
		Item item2= new Item(4154,1);
		inventory.set(5, item);
		inventory.set(6, item2);
		inventory.swap(true,5,6);
		assertEquals(inventory.slotOf(4153),6);
		assertEquals(inventory.slotOf(4154),5);
		inventory.swap(true,5,6);
		assertEquals(inventory.slotOf(4153),5);
		assertEquals(inventory.slotOf(4154),6);
	}
}