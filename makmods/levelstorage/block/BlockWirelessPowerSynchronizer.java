package makmods.levelstorage.block;

import ic2.api.item.Items;
import ic2.api.recipe.Recipes;

import java.util.Random;

import makmods.levelstorage.LSBlockItemList;
import makmods.levelstorage.LSCreativeTab;
import makmods.levelstorage.LevelStorage;
import makmods.levelstorage.init.IHasRecipe;
import makmods.levelstorage.proxy.ClientProxy;
import makmods.levelstorage.tileentity.TileEntityWirelessPowerSynchronizer;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockWirelessPowerSynchronizer extends BlockContainer implements IHasRecipe {

	public BlockWirelessPowerSynchronizer(int id) {
		super(id, Material.iron);
		if (FMLCommonHandler.instance().getSide().isClient()) {
			this.setCreativeTab(LSCreativeTab.instance);
		}
		this.setStepSound(Block.soundMetalFootstep);
		this.setHardness(3.0F);
	}

	private Icon down;
	private Icon up;
	private Icon side;

	public ItemStack advMachine = Items.getItem("advancedMachine");

	public void addCraftingRecipe() {
		ItemStack sync = new ItemStack(LSBlockItemList.blockWlessPowerSync, 4);
		ItemStack advCircuit = Items.getItem("advancedCircuit");
		ItemStack advMachine = Items.getItem("advancedMachine");
		Recipes.advRecipes.addRecipe(sync, "ccc", "ama", "ccc",
		        Character.valueOf('a'), advCircuit, Character.valueOf('c'),
		        new ItemStack(LSBlockItemList.blockWlessConductor),
		        Character.valueOf('m'), advMachine);

	}

	@Override
	public int idDropped(int par1, Random par2Random, int par3) {
		return this.advMachine.itemID;
	}

	@Override
	public int damageDropped(int par1) {
		return this.advMachine.getItemDamage();
	}

	@Override
	public void breakBlock(World world, int x, int y, int z, int par5, int par6) {
		this.dropItems(world, x, y, z);
		super.breakBlock(world, x, y, z, par5, par6);
	}

	private void dropItems(World world, int x, int y, int z) {
		Random rand = new Random();

		TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
		if (!(tileEntity instanceof IInventory))
			return;
		IInventory inventory = (IInventory) tileEntity;

		for (int i = 0; i < inventory.getSizeInventory(); i++) {
			ItemStack item = inventory.getStackInSlot(i);

			if (item != null && item.stackSize > 0) {
				float rx = rand.nextFloat() * 0.8F + 0.1F;
				float ry = rand.nextFloat() * 0.8F + 0.1F;
				float rz = rand.nextFloat() * 0.8F + 0.1F;

				EntityItem entityItem = new EntityItem(world, x + rx, y + ry, z
				        + rz, new ItemStack(item.itemID, item.stackSize,
				        item.getItemDamage()));

				if (item.hasTagCompound()) {
					entityItem.getEntityItem().setTagCompound(
					        (NBTTagCompound) item.getTagCompound().copy());
				}

				float factor = 0.05F;
				entityItem.motionX = rand.nextGaussian() * factor;
				entityItem.motionY = rand.nextGaussian() * factor + 0.2F;
				entityItem.motionZ = rand.nextGaussian() * factor;
				world.spawnEntityInWorld(entityItem);
				item.stackSize = 0;
			}
		}
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z,
	        EntityPlayer player, int par6, float par7, float par8, float par9) {
		if (player.isSneaking())
			return false;
		else {
			if (!world.isRemote) {
				TileEntityWirelessPowerSynchronizer tileWirelessSync = (TileEntityWirelessPowerSynchronizer) world
				        .getBlockTileEntity(x, y, z);
				if (tileWirelessSync != null) {
					player.openGui(LevelStorage.instance, 53, world, x, y, z);
				}
			}

			return true;
		}
		// return false;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int par2) {
		ForgeDirection orientation = ForgeDirection.VALID_DIRECTIONS[side];
		if (orientation == ForgeDirection.DOWN)
			return this.down;
		if (orientation == ForgeDirection.UP)
			return this.up;
		if (orientation == ForgeDirection.NORTH
		        || orientation == ForgeDirection.WEST
		        || orientation == ForgeDirection.SOUTH
		        || orientation == ForgeDirection.EAST)
			return this.side;
		return null;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister) {
		this.side = iconRegister
		        .registerIcon(ClientProxy.WIRELESS_POWER_SYNC_TEXTURE + "Side");
		this.up = iconRegister
		        .registerIcon(ClientProxy.WIRELESS_POWER_SYNC_TEXTURE + "Up");
		this.down = iconRegister
		        .registerIcon(ClientProxy.WIRELESS_POWER_SYNC_TEXTURE + "Down");
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityWirelessPowerSynchronizer();
	}

}