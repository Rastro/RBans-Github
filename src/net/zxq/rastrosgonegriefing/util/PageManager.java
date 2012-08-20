package net.zxq.rastrosgonegriefing.util;

import org.bukkit.ChatColor;

public class PageManager extends Pages {

	public static void printPage(RBPlayer player, int page) {
		player.setPages(makePages(player.getSearchResult()));

		player.print(ChatColor.DARK_GREEN + "+++++++SearchResults++++++++");
		player.print(getPlayerPage(player, page));
		player.print(ChatColor.DARK_GREEN + "++++++SearchResultsEnd++++++");
	}

	public static String[] getPlayerPage(RBPlayer player, int page) {
		String[][] pages = player.getPages();
		if(page >= pages.length) {
			String[] ret = {"No Page Found Here"};
			return ret;
		} else {
			String[] ret = pages[page];
			return ret;
		}
	}
}