package com.subatomicnetworks.subatomicscience.entities;

import com.mojang.authlib.GameProfile;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.play.client.CPacketClientSettings;
import net.minecraft.server.management.PlayerInteractionManager;
import net.minecraft.stats.StatBase;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.common.util.ITeleporter;
import net.minecraftforge.fml.common.FMLCommonHandler;

import java.util.UUID;

public class EntityFakePlayer extends EntityPlayerMP
{

    private static int index;

    public EntityFakePlayer(WorldServer world)
    {
        this(world, "HA_FakePlayer_" + (index++));
    }

    private EntityFakePlayer(WorldServer world, String name)
    {
        this(world, new GameProfile(UUID.randomUUID(), name));
    }

    private EntityFakePlayer(WorldServer world, GameProfile name)
    {
        super(FMLCommonHandler.instance().getMinecraftServerInstance(), world, name, new PlayerInteractionManager(world));
    }

    @Override
    public Vec3d getPositionVector()
    {
        return new Vec3d(0, 0, 0);
    }

    @Override
    public boolean canUseCommand(int i, String s)
    {
        return false;
    }

    @Override
    public void sendStatusMessage(ITextComponent chatComponent, boolean actionBar)
    {
    }

    @Override
    public void sendMessage(ITextComponent component)
    {
    }

    @Override
    public void addStat(StatBase par1StatBase, int par2)
    {
    }

    @Override
    public void openGui(Object mod, int modGuiId, World world, int x, int y, int z)
    {
    }

    @Override
    public boolean isEntityInvulnerable(DamageSource source)
    {
        return true;
    }

    @Override
    public boolean canAttackPlayer(EntityPlayer player)
    {
        return false;
    }

    @Override
    public void onDeath(DamageSource source)
    {
        return;
    }

    @Override
    public void onUpdate()
    {
        return;
    }

    @Override
    public Entity changeDimension(int dim, ITeleporter teleporter)
    {
        return this;
    }

    @Override
    public void handleClientSettings(CPacketClientSettings pkt)
    {
        return;
    }

}