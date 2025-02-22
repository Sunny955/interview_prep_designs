package org.lld.prep.multiinheritence;

public class LivingBeings implements Birds, Animals{
    @Override
    public void breathe() {
        Double t = 12.0;
        System.out.println(t.hashCode());
    }

    public static void main(String[] args) {
        LivingBeings lv = new LivingBeings();
        lv.breathe();
    }
}
