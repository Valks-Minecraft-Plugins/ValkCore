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
