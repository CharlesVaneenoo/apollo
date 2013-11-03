package org.apollo.game.model;

/**
 * Represents a single skill.
 * 
 * @author Graham
 */
public final class Skill {

	/**
	 * The agility id.
	 */
	public static final int AGILITY = 16;

	/**
	 * The attack id.
	 */
	public static final int ATTACK = 0;

	/**
	 * The cooking id.
	 */
	public static final int COOKING = 7;

	/**
	 * The crafting id.
	 */
	public static final int CRAFTING = 12;

	/**
	 * The defence id.
	 */
	public static final int DEFENCE = 1;

	/**
	 * The farming id.
	 */
	public static final int FARMING = 19;

	/**
	 * The firemaking id.
	 */
	public static final int FIREMAKING = 11;

	/**
	 * The fishing id.
	 */
	public static final int FISHING = 10;

	/**
	 * The fletching id.
	 */
	public static final int FLETCHING = 9;

	/**
	 * The herblore id.
	 */
	public static final int HERBLORE = 15;

	/**
	 * The hitpoints id.
	 */
	public static final int HITPOINTS = 3;

	/**
	 * The magic id.
	 */
	public static final int MAGIC = 6;

	/**
	 * The mining id.rivate
	 */
	public static final int MINING = 14;

	/**
	 * The prayer id.
	 */
	public static final int PRAYER = 5;

	/**
	 * The ranged id.
	 */
	public static final int RANGED = 4;

	/**
	 * The runecrafting id.
	 */
	public static final int RUNECRAFTING = 20;

	/**
	 * The skill names.
	 */
	private static final String SKILL_NAMES[] = { "Attack", "Defence", "Strength", "Hitpoints", "Ranged", "Prayer",
			"Magic", "Cooking", "Woodcutting", "Fletching", "Fishing", "Firemaking", "Crafting", "Smithing", "Mining",
			"Herblore", "Agility", "Thieving", "Slayer", "Farming", "Runecraft" };

	/**
	 * The slayer id.
	 */
	public static final int SLAYER = 18;

	/**
	 * The smithing id.
	 */
	public static final int SMITHING = 13;

	/**
	 * The strength id.
	 */
	public static final int STRENGTH = 2;

	/**
	 * The thieving id.
	 */
	public static final int THIEVING = 17;

	/**
	 * The woodcutting id.
	 */
	public static final int WOODCUTTING = 8;

	/**
	 * Gets the name of a skill.
	 * 
	 * @param id The skill's id.
	 * @return The skill's name.
	 */
	public static String getName(int id) {
		return SKILL_NAMES[id];
	}

	/**
	 * The current level.
	 */
	private final int currentLevel;

	/**
	 * The experience.
	 */
	private final double experience;

	/**
	 * The maximum level.
	 */
	private final int maximumLevel;

	/**
	 * Creates a skill.
	 * 
	 * @param experience The experience.
	 * @param currentLevel The current level.
	 * @param maximumLevel The maximum level.
	 */
	public Skill(double experience, int currentLevel, int maximumLevel) {
		this.experience = experience;
		this.currentLevel = currentLevel;
		this.maximumLevel = maximumLevel;
	}

	/**
	 * Gets the current level.
	 * 
	 * @return The current level.
	 */
	public int getCurrentLevel() {
		return currentLevel;
	}

	/**
	 * Gets the experience.
	 * 
	 * @return The experience.
	 */
	public double getExperience() {
		return experience;
	}

	/**
	 * Gets the maximum level.
	 * 
	 * @return The maximum level.
	 */
	public int getMaximumLevel() {
		return maximumLevel;
	}

}