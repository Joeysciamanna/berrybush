package ch.g_7.berrybush.game.obj;

import ch.g_7.berrybush.common.Util;
import ch.g_7.berrybush.game.item.IItem;
import ch.g_7.berrybush.game.item.ITool;
import ch.g_7.berrybush.game.view_model.ImageType;
import ch.g_7.berrybush.game.view_model.ImagedViewModel;
import ch.g_7.berrybush.math.Vector2f;
import ch.g_7.berrybush.server.game.World;
import ch.g_7.util.helper.RandomUtil;

import java.util.ArrayList;
import java.util.List;

public class LootChest extends GameObject<ImagedViewModel> implements Interactable {

    private static final int DROP_RANGE = 20;

    private final List<IItem> items;
    private final World world;
    private boolean open;


    public LootChest(Vector2f position, int id, World world) {
        super(position, new ImagedViewModel(ImageType.CHEST, id), id);
        this.items = new ArrayList<>();
        this.world = world;
    }

    @Override
    public boolean interact(IBeeing beeing, ITool tool) {
        if (open)
            return false;
        ((ImagedViewModel) getViewModel()).setImageType(ImageType.CHEST_OPEN);
        items.forEach(this::drop);
        open = true;
        return true;
    }

    private void drop(IItem item) {
        Vector2f pos = Util.randomPosition(-DROP_RANGE, DROP_RANGE, -DROP_RANGE, DROP_RANGE).add(getPosition());
        item.getTransform().setPosition(pos);
        world.add(item);
    }
}
