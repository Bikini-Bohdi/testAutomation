package net.unethicalite.trawler;

import com.google.inject.Provides;
import net.unethicalite.api.entities.NPCs;
import net.unethicalite.api.entities.Players;
import net.unethicalite.api.entities.TileObjects;
import net.unethicalite.api.plugins.LoopedPlugin;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.NPC;
import net.runelite.api.Player;
import net.runelite.api.TileObject;
import net.runelite.api.coords.WorldArea;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.PluginDescriptor;
import org.pf4j.Extension;

@PluginDescriptor(name = "Hoot Trawler", enabledByDefault = false)
@Extension
@Slf4j
public class HootTrawlerPlugin extends LoopedPlugin
{
	private final WorldPoint miningSpot = new WorldPoint(3287, 3366, 0);

	@Override
	protected int loop()
	{
		
		walkTo​(BankLocation VARROCK_EAST_BANK)
		if (Bank.isOpen())
		{
			Bank.depositInventory();
			return -2;
		}

		NPC banker = NPCs.getNearest(x -> x.hasAction("Collect"));
		if (banker != null)
		{
			banker.interact("Bank");
			return -3;
		}
		walkTo(miningSpot)
		return sleepDelay().toInt()
		

	}
	
	@Provides
	public HootTrawlerConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(HootTrawlerConfig.class);
	}
}
