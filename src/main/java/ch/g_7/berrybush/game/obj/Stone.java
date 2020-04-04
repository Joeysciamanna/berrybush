package ch.g_7.berrybush.game.obj;

import ch.g_7.berrybush.common.Util;
import ch.g_7.berrybush.framework.IViewModel;
import ch.g_7.berrybush.game.item.ITool;
import ch.g_7.berrybush.game.view_model.ClusterViewModel;
import ch.g_7.berrybush.game.view_model.ImageType;
import ch.g_7.berrybush.game.view_model.ImagedViewModel;
import ch.g_7.berrybush.main.Resource;
import ch.g_7.berrybush.math.Vector2f;
import ch.g_7.berrybush.server.game.World;
import ch.g_7.util.helper.RandomUtil;

public class Stone extends GameObject<ClusterViewModel> implements Damagable {

    private final World world;

    public Stone(Vector2f position, Vector2f scale, World world, int id) {
        super(position, generateClusterModel(id, scale), id);
        this.world = world;
    }

    private static ClusterViewModel generateClusterModel(int id, Vector2f scale) {
        boolean hasIron = RandomUtil.chance(0.1f);
        if(hasIron)
            return new ClusterViewModel(id, 0.01f, scale, ImageType.STONE_CLUSTER_1, ImageType.STONE_CLUSTER_2, ImageType.STONE_CLUSTER_3, ImageType.IRON_CLUSTER_1, ImageType.IRON_CLUSTER_2, ImageType.IRON_CLUSTER_3);
        return new ClusterViewModel(id, 0.01f, scale, ImageType.STONE_CLUSTER_1, ImageType.STONE_CLUSTER_2, ImageType.STONE_CLUSTER_3);

    }

    @Override
    public void damage(ITool tool) {
        float clusterCount = getViewModel().getClusterDensity() - 0.000001f;
        if(clusterCount>0){
            getViewModel().setClusterDensity(clusterCount);
        }

    }

    @Override
    public void doBreak() {
        world.remove(this);
    }
}
