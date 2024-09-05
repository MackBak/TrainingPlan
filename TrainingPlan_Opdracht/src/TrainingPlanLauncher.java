public class TrainingPlanLauncher {

    public static void main(String[] args) {

        HardloopPlan hardloopPlan1 = new HardloopPlan.HardloopPlanBuilder(4, 5)  // 4 sessies/week, 5 km/sessie
                .intensiteit("Gemiddeld")
                .doelTempo("6:00 min/km")
                .build();
        hardloopPlan1.toonPlan();


        FietsPlan fietsPlan = new FietsPlan.FietsPlanBuilder(3, 30)  // 3 sessies/week, 30 km/sessie
                .intensiteit("Zwaar")
                .hoogtemeters(500)
                .fietsSoort("Mountainbike")
                .build();
        fietsPlan.toonPlan();

        HardloopPlan hardloopPlan2 = new HardloopPlan.HardloopPlanBuilder(6, 7)
                .intensiteit("Intensief")
                .doelTempo("4:45 min/km")
                .warmingUpTijd(15)
                .rustDagen(1)
                .build();
        hardloopPlan2.toonPlan();

    }
}

// Verwachte output:

//  Hardloopplan: 4 sessies/week, 5,00 km per sessie, Intensiteit: Gemiddeld, Doeltempo: 6:00 min/km, Warming-up: 10 minuten, Rustdagen: 2
//  Fietsplan: 3 sessies/week, 30,00 km per sessie, Intensiteit: Zwaar, Hoogtemeters: 300,00 meter, Fietssoort: Mountainbike
//  Hardloopplan: 6 sessies/week, 7,00 km per sessie, Intensiteit: Intensief, Doeltempo: 4:45 min/km, Warming-up: 15 minuten, Rustdagen: 1