### What is ValkCore?
ValkCore is a package of utilities that may assist you in plugins that you develop.

Do not use this core plugin as a direct dependency as there are some unneeded GUI listeners that could potentially slow down your plugin. Instead simply copy the class you want to use and put it in your Utils package.

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
