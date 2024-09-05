public class HardloopPlan extends TrainingPlan {

    private final String doelTempo;
    private final int warmingUpTijd;

    private HardloopPlan(HardloopPlanBuilder builder) {
        super(builder);
        this.doelTempo = builder.doelTempo;
        this.warmingUpTijd = builder.warmingUpTijd;
    }

    @Override
    public void toonPlan() {
        System.out.printf("Hardloopplan: %d sessies/week, %.2f km per sessie, Intensiteit: %s, " +
                        "Doeltempo: %s, Warming-up: %d minuten, Rustdagen: %d\n",
                sessiesPerWeek, afstandPerSessie, intensiteit, doelTempo, warmingUpTijd, rustDagen);
    }

    // Concrete builder klasse voor het bouwen van een HardloopPlan
    public static class HardloopPlanBuilder extends TrainingPlanBuilder<HardloopPlanBuilder> {
        private String doelTempo = "Geen";  // Standaardwaarde
        private int warmingUpTijd = 10;     // Standaardwaarde

        public HardloopPlanBuilder(int sessiesPerWeek, double afstandPerSessie) {
            super(sessiesPerWeek, afstandPerSessie);
        }

        public HardloopPlanBuilder doelTempo(String doelTempo) {
            this.doelTempo = doelTempo;
            return this;
        }

        public HardloopPlanBuilder warmingUpTijd(int warmingUpTijd) {
            this.warmingUpTijd = warmingUpTijd;
            return this;
        }

        @Override
        protected HardloopPlanBuilder self() {
            return this;
        }

        @Override
        public HardloopPlan build() {
            return new HardloopPlan(this);
        }
    }
}
