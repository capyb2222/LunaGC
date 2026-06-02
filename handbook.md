# Handbook 
(Not to be confused with the one that GC generates)


## How to make or get custom banners?

- Pre-made: [github repo](https://github.com/Zhaokugua/Grasscutter_Banners)
- Rename the file you chose to download to Banners.json and replace it with the already-existing one in the data folder.
- The repo also offers a file which contains all of the banners, to use it follow the same procedure mentioned above.

  ### Making custom banners

- If you want to make a custom banner for a character or weapon, you'll need to know the prefabPath, the titlePath and the character/item IDs.
- Fun fact: You can set any item to be on the rateUp, even if it's a 4* instead of a 5*.


## Various commands

- Create accounts: /account <username>
- Get all achievements: /am grantall
- God mode: /prop god 1
- Enter a domain: /dungeon <ID>
- Unlimited stamina: /prop ns 0
- Unlimited energy: /prop UnlimitedEnergy 1
- Recharge energy: /er
- Set constellation for selected character: /setConst <number 1 to 6>
- Get rid of the skill cooldown: /stat cdr 99
- Change weather: /weather <sunny/rain/cloudy/thunderstorm/snow/mist>
- Change talent for selected character: /talent <n/e/q/all> <level> (n - normal attack only) (e - skill only) (q - burst only)
- Give items: /g <itemId|avatarId|all|weapons|mats|avatars> [lv<number>] [r<refinement number>] [x<amount>] [c<constellation number>] [sl<skilllevel>]
- Unlock all: /unlockall
- Change world level: /prop wl <number>
- Change AR: /prop player_level <number between 1 and 60>
- Change the game speed: /gamespeed <0.1|0.2|0.5|0.75|1.0|1.5|2.0|3.0>
- Get 9999 Intertwined fates: /g 223 x9999
- Get 9999 Acquaint fates: /g 224 x9999
- Get 9999 Mora: /g 202 x9999
- Get 9999 Primogems: /g 201 x9999


  ### Make sure to not include <> or [] in the commands! The stuff in <> means its required and the stuff in [] means its optional.

  ### How to get all of the stuff maxed out: /g all lv90 r5 c6 c6 sl10 | Then do a separate one for the materials: /g mats x99999


## Ways to TP around the map:  

Method 1:

- 1: Unlock the map: /prop um 1
- 2: Open the map
- 3: Use the waypoints

Method 2:

- 1: Open the map
- 2: Place a fishing rod marker (the last one) where you want to teleport and mark it.

## How to get avatar/entity/material etc. IDs?

- Go to [gi.yotta.moe](https://gi.yatta.moe/en)
- Search up the material/avatar/enemy and then the ID of it should be in the URL of the site, for example I searched for the pyro hilichurl archer; the link for it is gi.yotta.moe/en/archive/monster/21010501/pyro-hilichurl-shooter so the ID for it will be 21010501.

## How to spawn monsters?

- Get the ID from the ambr.top link (above)
- Do /spawn <id> in the in-game chat. You can also find out more arguments that you can use to modify the monster hp etc by doing `/help spawn` or `/spawn` | Example: `/spawn 21010501`, that will spawn a pyro hilichurl. Give it more hp: `/spawn 21010501 hp9999` and you can find more about the arguments trough the method I mentioned above.

## How to use the /uid command?

- Rich text is supported
- How to set custom UID: `/uid set changethistext` | bold: `/uid set <b>changethistext</b>` | italic: `/uid set <i>changethistext</i>` | combined: `/uid set <i><b>changethistext</b></i>` | colored text (you'll need a hex color code, you can easy get and pick one by search hex color picker on google now let's assume that you have done it): `/uid set <color=#698ae8>changethistext</color>`
- You can also include spaces like this: `/uid set <b>B O L D</b>`
- You can combine the bold, italic and colored text
- Restore to server-default UID: `/uid default`