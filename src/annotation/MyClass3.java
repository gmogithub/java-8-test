package annotation;

public class MyClass3 {
    @Todos(
            {
                    @Todo(
                            description = "Penser à faire les initialisations...",
                            destinataire = "zozor",
                            niveau = NIVEAU.BUG),
                    @Todo(
                            description = "Aucune gestion d'exception ! ",
                            destinataire = "zozor",
                            niveau = NIVEAU.AMELIORATION)
            }
    )
    public void doSomething(
            @Todo(
                    niveau = NIVEAU.BUG,
                    description = "Vérifier le contenu de ce paramètre",
                    destinataire = "ssr"
            )
                    String str) {
    }

}
