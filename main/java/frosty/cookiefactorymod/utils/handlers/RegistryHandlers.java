package frosty.cookiefactorymod.utils.handlers;

import com.google.common.eventbus.Subscribe;

import frosty.cookiefactorymod.init.ItemInit;
import frosty.cookiefactorymod.utils.IHasModel;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class RegistryHandlers {

	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(ItemInit.ITEMS.toArray(new Item[0]));
	}
	
	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent event) {
		for(Item item : ItemInit.ITEMS){
			if(item instanceof IHasModel){
				((IHasModel)item).registerModels();
			}
		}
	}
	
}
