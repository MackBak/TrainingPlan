public class FietsPlan extends TrainingPlan {

    private final double hoogtemeters;
    private final String fietsSoort;

    private FietsPlan(FietsPlanBuilder builder) {
        super(builder);
        this.hoogtemeters = builder.hoogtemeters;
        this.fietsSoort = builder.fietsSoort;
    }

    @Override
    public void toonPlan() {
        System.out.printf("Fietsplan: %d sessies/week, %.2f km per sessie, Intensiteit: %s, " +
                        "Hoogtemeters: %.2f meter, Fietssoort: %s\n",
                sessiesPerWeek, afstandPerSessie, intensiteit, hoogtemeters, fietsSoort);
    }

    // Concrete builder klasse voor het bouwen van een FietsPlan
    public static class FietsPlanBuilder extends TrainingPlanBuilder<FietsPlanBuilder> {
        private double hoogtemeters = 0;            // Standaardwaarde
        private String fietsSoort = "Racefiets";    // Standaard fietssoort

        public FietsPlanBuilder(int sessiesPerWeek, double afstandPerSessie) {
            super(sessiesPerWeek, afstandPerSessie);
        }

        public FietsPlanBuilder hoogtemeters(double hoogtemeters) {
            this.hoogtemeters = hoogtemeters;
            return this;
        }

        public FietsPlanBuilder fietsSoort(String fietsSoort) {
            this.fietsSoort = fietsSoort;
            return this;
        }

        @Override
        protected FietsPlanBuilder self() {
            return this;
        }

        @Override
        public FietsPlan build() {
            return new FietsPlan(this);
        }
    }
}
