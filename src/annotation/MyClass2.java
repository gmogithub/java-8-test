package annotation;
@Todo(
      niveau = NIVEAU.CRITIQUE,
      description = "Il faudrait penser à terminer la classe.",
      destinataire = "ssr"
)
public class MyClass2 extends MyClass1{
    @Todos(
         {
            @Todo(
                  description = "Mais que fait cette méthode ?",
                  destinataire = "zéro",
                  niveau = NIVEAU.BUG),
            @Todo(
                  description = "Pourquoi tant de N !",
                  destinataire = "cysboy",
                  niveau = NIVEAU.AMELIORATION)
         }
   )
   public String doSomething(){
      return "something :p ";
   }
}
