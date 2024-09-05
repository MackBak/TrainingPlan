public abstract class TrainingPlan {

    protected final int sessiesPerWeek;
    protected final double afstandPerSessie;
    protected final String intensiteit;
    protected final int rustDagen;

    protected TrainingPlan(TrainingPlanBuilder<?> builder) {
        this.sessiesPerWeek = builder.sessiesPerWeek;
        this.afstandPerSessie = builder.afstandPerSessie;
        this.intensiteit = builder.intensiteit;
        this.rustDagen = builder.rustDagen;
    }

    public abstract void toonPlan();

    // Abstracte builder klasse voor gemeenschappelijke attributen
    public static abstract class TrainingPlanBuilder<T extends TrainingPlanBuilder<T>> {
        protected final int sessiesPerWeek;
        protected final double afstandPerSessie;
        protected String intensiteit = "Gemiddeld";  // Niet verplicht, standaardwaarde
        protected int rustDagen = 2;                 // Niet verplicht, standaardwaarde

        public TrainingPlanBuilder(int sessiesPerWeek, double afstandPerSessie) {
            this.sessiesPerWeek = sessiesPerWeek;
            this.afstandPerSessie = afstandPerSessie;
        }

        public T intensiteit(String intensiteit) {
            this.intensiteit = intensiteit;
            return self();
        }

        public T rustDagen(int rustDagen) {
            this.rustDagen = rustDagen;
            return self();
        }

        // Methode om de subklasse builder type te retourneren
        protected abstract T self();

        public abstract TrainingPlan build();
    }
}
