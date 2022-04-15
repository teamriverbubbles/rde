package teamriverbubbles.rde.Events;
/*    Copyright (c) 2022, Xavier Horwood,
 *    All rights reserved
 *
 *    This file is part of the Rde (Random effect every death). Redistribution and use in source and
 *    binary forms, with or without modification, are permitted exclusively
 *    under the terms of the Apache license. You should have received
 *    a copy of the license with this file. If not, please or visit:
 *    https://github.com/teamriverbubbles/rde/blob/master/License.
 */
import dev.dejvokep.boostedyaml.YamlDocument;
import dev.dejvokep.boostedyaml.settings.dumper.DumperSettings;
import dev.dejvokep.boostedyaml.settings.general.GeneralSettings;
import dev.dejvokep.boostedyaml.settings.loader.LoaderSettings;
import dev.dejvokep.boostedyaml.settings.updater.UpdaterSettings;
import dev.dejvokep.boostedyaml.spigot.SpigotSerializer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.potion.PotionEffectType;
import teamriverbubbles.rde.Rde;
import org.bukkit.event.player.PlayerRespawnEvent;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Player implements Listener {

    Random random = new Random();
    Rde plugin;

    public Player(Rde plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerKill(org.bukkit.event.entity.EntityDeathEvent event) throws IOException {
            if (event.getEntity().getKiller() != null) {
                if(event.getEntity().getKiller().getType() == org.bukkit.entity.EntityType.PLAYER) {
                int randomNumber = random.nextInt(30);
                int duration = plugin.getConfig().getInt("override-duration");
                if(duration == 0) duration = Integer.MAX_VALUE;
                YamlDocument config = YamlDocument.create(new File(plugin.getDataFolder(), "playerdata.yml"), plugin.getResource("playerdata.yml"), GeneralSettings.builder().setSerializer(SpigotSerializer.getInstance()).build(), LoaderSettings.DEFAULT, DumperSettings.DEFAULT, UpdaterSettings.DEFAULT);
                config.set(event.getEntity().getKiller().getUniqueId() + ".effect", randomNumber);
                config.save();

                YamlDocument mainconfig = YamlDocument.create(new File(plugin.getDataFolder(), "config.yml"), plugin.getResource("config.yml"), GeneralSettings.builder().setSerializer(SpigotSerializer.getInstance()).build(), LoaderSettings.DEFAULT, DumperSettings.DEFAULT, UpdaterSettings.DEFAULT);
                int amplifier = (int) mainconfig.get("amplifier");
                event.getEntity().getKiller().sendMessage("You killed " + event.getEntity().getName() + "! You got a random number: " + randomNumber);
                switch(randomNumber) {
                    case 0: break;
                    case 1: event.getEntity().getKiller().addPotionEffect(PotionEffectType.ABSORPTION.createEffect(duration, amplifier)); break;
                    case 2: event.getEntity().getKiller().addPotionEffect(PotionEffectType.BAD_OMEN.createEffect(duration, amplifier)); break;
                    case 3: event.getEntity().getKiller().addPotionEffect(PotionEffectType.BLINDNESS.createEffect(duration, amplifier)); break;
                    case 4: event.getEntity().getKiller().addPotionEffect(PotionEffectType.CONFUSION.createEffect(duration, amplifier)); break;
                    case 5: event.getEntity().getKiller().addPotionEffect(PotionEffectType.DAMAGE_RESISTANCE.createEffect(duration, amplifier)); break;
                    case 6: event.getEntity().getKiller().addPotionEffect(PotionEffectType.DOLPHINS_GRACE.createEffect(duration, amplifier)); break;
                    case 7: event.getEntity().getKiller().addPotionEffect(PotionEffectType.FAST_DIGGING.createEffect(duration, amplifier)); break;
                    case 8: event.getEntity().getKiller().addPotionEffect(PotionEffectType.FIRE_RESISTANCE.createEffect(duration, amplifier)); break;
                    case 9: event.getEntity().getKiller().addPotionEffect(PotionEffectType.GLOWING.createEffect(duration, amplifier)); break;
                    case 10: event.getEntity().getKiller().addPotionEffect(PotionEffectType.HARM.createEffect(duration, amplifier)); break;
                    case 11: event.getEntity().getKiller().addPotionEffect(PotionEffectType.HEAL.createEffect(duration, amplifier)); break;
                    case 12: event.getEntity().getKiller().addPotionEffect(PotionEffectType.HEALTH_BOOST.createEffect(duration, amplifier)); break;
                    case 13: event.getEntity().getKiller().addPotionEffect(PotionEffectType.HERO_OF_THE_VILLAGE.createEffect(duration, amplifier)); break;
                    case 14: event.getEntity().getKiller().addPotionEffect(PotionEffectType.HUNGER.createEffect(duration, amplifier)); break;
                    case 15: event.getEntity().getKiller().addPotionEffect(PotionEffectType.INCREASE_DAMAGE.createEffect(duration, amplifier)); break;
                    case 16: event.getEntity().getKiller().addPotionEffect(PotionEffectType.INVISIBILITY.createEffect(duration, amplifier)); break;
                    case 17: event.getEntity().getKiller().addPotionEffect(PotionEffectType.JUMP.createEffect(duration, amplifier)); break;
                    case 18: event.getEntity().getKiller().addPotionEffect(PotionEffectType.LEVITATION.createEffect(duration, amplifier)); break;
                    case 19: event.getEntity().getKiller().addPotionEffect(PotionEffectType.LUCK.createEffect(duration, amplifier)); break;
                    case 20: event.getEntity().getKiller().addPotionEffect(PotionEffectType.NIGHT_VISION.createEffect(duration, amplifier)); break;
                    case 21: event.getEntity().getKiller().addPotionEffect(PotionEffectType.POISON.createEffect(duration, amplifier)); break;
                    case 22: event.getEntity().getKiller().addPotionEffect(PotionEffectType.REGENERATION.createEffect(duration, amplifier)); break;
                    case 23: event.getEntity().getKiller().addPotionEffect(PotionEffectType.SATURATION.createEffect(duration, amplifier)); break;
                    case 24: event.getEntity().getKiller().addPotionEffect(PotionEffectType.SLOW.createEffect(duration, amplifier)); break;
                    case 25: event.getEntity().getKiller().addPotionEffect(PotionEffectType.SLOW_DIGGING.createEffect(duration, amplifier)); break;
                    case 26: event.getEntity().getKiller().addPotionEffect(PotionEffectType.SLOW_FALLING.createEffect(duration, amplifier)); break;
                    case 27: event.getEntity().getKiller().addPotionEffect(PotionEffectType.SPEED.createEffect(duration, amplifier)); break;
                    case 28: event.getEntity().getKiller().addPotionEffect(PotionEffectType.UNLUCK.createEffect(duration, amplifier)); break;
                    case 29: event.getEntity().getKiller().addPotionEffect(PotionEffectType.WATER_BREATHING.createEffect(duration, amplifier)); break;
                    case 30: event.getEntity().getKiller().addPotionEffect(PotionEffectType.WEAKNESS.createEffect(duration, amplifier)); break;
                    case 31: event.getEntity().getKiller().addPotionEffect(PotionEffectType.WITHER.createEffect(duration, amplifier)); break;
                }
            }
        }

    }

    @EventHandler
    public void PlayerRespawnEvent(PlayerRespawnEvent event) throws IOException {
        Bukkit.getScheduler().runTaskLater(plugin, () -> {
            //int randomNumber = plugin.getCustomConfig().getInt(event.getPlayer().getUniqueId() + ".effect");
            YamlDocument config = null;
            try {
                config = YamlDocument.create(new File(plugin.getDataFolder(), "playerdata.yml"), plugin.getResource("playerdata.yml"), GeneralSettings.builder().setSerializer(SpigotSerializer.getInstance()).build(), LoaderSettings.DEFAULT, DumperSettings.DEFAULT, UpdaterSettings.DEFAULT);
            } catch (IOException e) {
                e.printStackTrace();
            }
            int randomNumber = config.getInt(event.getPlayer().getUniqueId() + ".effect");
            //event.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', "&aYou have been given the effect of &b" + randomNumber));
            int duration = plugin.getConfig().getInt("override-duration");
            if(duration == 0) duration = Integer.MAX_VALUE;
            YamlDocument mainconfig = null;
            try {
                mainconfig = YamlDocument.create(new File(plugin.getDataFolder(), "config.yml"), plugin.getResource("config.yml"), GeneralSettings.builder().setSerializer(SpigotSerializer.getInstance()).build(), LoaderSettings.DEFAULT, DumperSettings.DEFAULT, UpdaterSettings.DEFAULT);
            } catch (IOException e) {
                e.printStackTrace();
            }
            int amplifier = (int) mainconfig.getInt("amplifier");

            switch (randomNumber) {
                case 1: event.getPlayer().addPotionEffect(PotionEffectType.ABSORPTION.createEffect(duration, amplifier)); break;
                case 2: event.getPlayer().addPotionEffect(PotionEffectType.BAD_OMEN.createEffect(duration, amplifier)); break;
                case 3: event.getPlayer().addPotionEffect(PotionEffectType.BLINDNESS.createEffect(duration, amplifier)); break;
                case 4: event.getPlayer().addPotionEffect(PotionEffectType.CONFUSION.createEffect(duration, amplifier)); break;
                case 5: event.getPlayer().addPotionEffect(PotionEffectType.DAMAGE_RESISTANCE.createEffect(duration, amplifier)); break;
                case 6: event.getPlayer().addPotionEffect(PotionEffectType.DOLPHINS_GRACE.createEffect(duration, amplifier)); break;
                case 7: event.getPlayer().addPotionEffect(PotionEffectType.FAST_DIGGING.createEffect(duration, amplifier)); break;
                case 8: event.getPlayer().addPotionEffect(PotionEffectType.FIRE_RESISTANCE.createEffect(duration, amplifier)); break;
                case 9: event.getPlayer().addPotionEffect(PotionEffectType.GLOWING.createEffect(duration, amplifier)); break;
                case 10: event.getPlayer().addPotionEffect(PotionEffectType.HARM.createEffect(duration, amplifier)); break;
                case 11: event.getPlayer().addPotionEffect(PotionEffectType.HEAL.createEffect(duration, amplifier)); break;
                case 12: event.getPlayer().addPotionEffect(PotionEffectType.HEALTH_BOOST.createEffect(duration, amplifier)); break;
                case 13: event.getPlayer().addPotionEffect(PotionEffectType.HERO_OF_THE_VILLAGE.createEffect(duration, amplifier)); break;
                case 14: event.getPlayer().addPotionEffect(PotionEffectType.HUNGER.createEffect(duration, amplifier)); break;
                case 15: event.getPlayer().addPotionEffect(PotionEffectType.INCREASE_DAMAGE.createEffect(duration, amplifier)); break;
                case 16: event.getPlayer().addPotionEffect(PotionEffectType.INVISIBILITY.createEffect(duration, amplifier)); break;
                case 17: event.getPlayer().addPotionEffect(PotionEffectType.JUMP.createEffect(duration, amplifier)); break;
                case 18: event.getPlayer().addPotionEffect(PotionEffectType.LEVITATION.createEffect(duration, amplifier)); break;
                case 19: event.getPlayer().addPotionEffect(PotionEffectType.LUCK.createEffect(duration, amplifier)); break;
                case 20: event.getPlayer().addPotionEffect(PotionEffectType.NIGHT_VISION.createEffect(duration, amplifier)); break;
                case 21: event.getPlayer().addPotionEffect(PotionEffectType.POISON.createEffect(duration, amplifier)); break;
                case 22: event.getPlayer().addPotionEffect(PotionEffectType.REGENERATION.createEffect(duration, amplifier)); break;
                case 23: event.getPlayer().addPotionEffect(PotionEffectType.SATURATION.createEffect(duration, amplifier)); break;
                case 24: event.getPlayer().addPotionEffect(PotionEffectType.SLOW.createEffect(duration, amplifier)); break;
                case 25: event.getPlayer().addPotionEffect(PotionEffectType.SLOW_DIGGING.createEffect(duration, amplifier)); break;
                case 26: event.getPlayer().addPotionEffect(PotionEffectType.SLOW_FALLING.createEffect(duration, amplifier)); break;
                case 27: event.getPlayer().addPotionEffect(PotionEffectType.SPEED.createEffect(duration, amplifier)); break;
                case 28: event.getPlayer().addPotionEffect(PotionEffectType.UNLUCK.createEffect(duration, amplifier)); break;
                case 29: event.getPlayer().addPotionEffect(PotionEffectType.WATER_BREATHING.createEffect(duration, amplifier)); break;
                case 30: event.getPlayer().addPotionEffect(PotionEffectType.WEAKNESS.createEffect(duration, amplifier)); break;
                case 31: event.getPlayer().addPotionEffect(PotionEffectType.WITHER.createEffect(duration, amplifier)); break;
            }

        }, 20L);

    }

}
