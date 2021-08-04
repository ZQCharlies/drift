package design.BuilderPattern;

/**
 * @Author wzq
 * @Date 2021/8/4
 * 恶魔角色构造器：具体构造器
 **/
public class DevilActorBuilder extends ActorBuilder{
    @Override
    public void buildType() {
        actor.setType("恶魔");
    }

    @Override
    public void buildSex() {
        actor.setSex("男");
    }

    @Override
    public void buildFace() {
        actor.setFace("丑陋");
    }

    @Override
    public void buildCostume() {
        actor.setCostume("黑衣");
    }

    @Override
    public void buildHairstyle() {
        actor.setHairstyle("光头");
    }
}
