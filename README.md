### What is ValkCore?
ValkCore is a package of utilities that may assist you in plugins that you develop.

Do not use this core plugin as a direct dependency as there are some unneeded GUI listeners that could potentially slow down your plugin. Instead simply copy the class you want to use and put it in your Utils package.

If you're using intelliJ or another IDE, simply ignore all eclipse related files in this repository.

### Contributing
If you're interested in contributing, send me a message over on discord at **valk#3277**.

### Modules
`BlockModule`, `ItemModule`, `MobModule`, `PlayerModule`, `TextModule`, `ToolModule`, and `WorldModule` have tons of static utility methods that you can use to your advantage. Some examples are listed below. **Not all methods are listed and I encourage you to look at the class code directly to get a better insight!**

#### Boolean
Check if the block you're breaking is of type log. There are many other methods like this such as `isFarmable`, `isLeaves`, `isOre`, `isStrippedWood`, `isSoftBlock`, `isChest`, `isStation`, `isLiquid`, `isMineBlock`, and `isPlant`. Other methods exist like this in `MobModule`, `ToolModule` and `WorldModule`.
```java
Material blockToBeMined = getBlockToBeMined();
if (BlockModule.isLog(blockToBeMined)) {
  // Do something.
}
```
Another useful example would be to check if it's daytime using the `WorldModule`.
```java
if (WorldModule.day()) {
  // It is day!
} else {
  // It is night!
}
```

#### Void
Inside your BlockBreakEvent pass the event variable to this method and watch the magic unfold before your eyes.
```java
BlockModule.treeGravity(event);
```

#### ItemStack
Tired of setting item meta manually? This will do it for you! Same idea goes for `tool`, `potion` and `splashPotion`.
```java
ItemModule.item("ItemName", "Lore\nLine 2\nLine 3", Material.APPLE);
```

#### String
You no longer have to use `ChatColor.TranslateAlternateColorCodes(...)`, instead you can simply do `TextModule.color("&2Color &amessage.")`. The method also has hard coded primary and secondary colors if you want your plugin to follow a theme with main 2 colors.
```java
Bukkit.broadcastMessage(TextModule.color("&cRed &dPink"));
```

### ConfigItem
Store items into a config.
```java
// Create a config manager for the 'items.yml' config.
ConfigManager cm = new ConfigManager("items"); 
// Create an instance from the ConfigItem class. (This really should all be static, I will fix this later.)
ConfigItem configItem = new ConfigItem(cm); 
// Use the instance to set the item in your config.
configItem.set("my.item.path.one", new ItemStack(Material.FEATHER)); 
// Set another if you want.
configItem.set("my.item.path.two", new ItemStack(Material.COAL)); 
// Save the config otherwise our values will be lost on reload.
cm.saveConfig(); 
```
Then access the item from somewhere else.
```java
// Grab the feather from the config.
ItemStack feather = configItem.get("my.item.path.one"); 
// Grab the coal from the config.
ItemStack coal = configItem.get("my.item.path.two"); 
// Do something with the feather.
System.out.println(feather); 
// Do something with the coal.
System.out.println(coal); 
```
The similar code structure can be applied to the `ConfigEquipment`, `ConfigInv`, `ConfigLocation`, and `ConfigPlayer`.

### Cooldown
Lets say we wanted to have a cooldown on a summon wolf command.
```java
// Cooldowns are tracked via player UUID.
UUID id = player.getUniqueId();

// Is there no cooldown in effect for this player?
if (!Cooldown.isInCooldown(id)) {
  // If so create a new cooldown for them.
  new Cooldown(id, 10);
  // Proceed with executing our summon command.
  summonWolfPet("Snuppy");
} else {
  // Tell the player their still on cooldown.
  int timeLeft = Cooldown.getTimeLeft(id);
  player.sendMessage("You're on cooldown! Please wait " + timeLeft + " more seconds!");
}
```

### Hologram
Holograms are fairly easy to create. I encourage you to modify the hologram class to be one of your own. When I have time I may modify it myself.
```java
// Create our hologram at 'location' with the message "Hello world!"
Hologram hologram = new Hologram(location, "Hello world!");
// Holograms are set to invisible by default, so we make it visible.
hologram.setVisible(true);
// Update our hologram name.
hologram.updateName("Hi!");
// Move our hologram upwards.
hologram.move();
// Destroy our hologram.
hologram.destroy();
// You may want to put move() and destroy() into one or more bukkit runnables to get a dynamic effect.
// This is why I encourage you to look into expanding the hologram class to automate these sorts of things.
```
