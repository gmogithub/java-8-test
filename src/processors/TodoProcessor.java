package processors;

import annotation.Todo;
import annotation.Todos;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import java.util.Set;


//Permet de spécifier les annotations à traiter
@SupportedAnnotationTypes(value = {"annotation.Todo", "annotation.Todos"})
//Définit quelle version de source gérer, ici je code en Java 8
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class TodoProcessor extends AbstractProcessor {
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        System.out.println("Début du traitement console !");
        Todo[] todosArray = {};
        //Nous parcourons toutes les annotations concernées par ce processeur
        for (TypeElement te : annotations) {
            System.out.println("Traitement annotation " + te.getQualifiedName());
            Class obj = null;
            try {
                obj = Class.forName(te.getQualifiedName().toString());
            } catch (ClassNotFoundException e) {
                System.out.println("error");
            }
            //Permet de récupérer tous les éléments annotés avec l'annotation en cours
            for (Element element : roundEnv.getElementsAnnotatedWith(te)) {
                String name = element.getClass().toString();
                System.out.println("---------------------------------- name ----------------------- " + name);
                //Permet de savoir quel type d'élément est annoté (constructeur, paramètre, classe...)
                System.out.println("\n Type d'élément annoté : " + element.getKind() + "\n");

                //retourne le nom de l'élément annoté, le nom de la variable, le nom de la classe...
                System.out.println("\t --> Traitement de l'élément : " + element.getSimpleName() + "\n");

                //Différentes informations sur l'élément annoté
                System.out.println("enclosed elements : " + element.getEnclosedElements());
                System.out.println("as type : " + element.asType());
                System.out.println("enclosing element : " + element.getEnclosingElement() + "\n");

                //Nous récupérons notre annotation
                /// Todo todo = element.getAnnotation(Todo.class);
                System.out.println(obj.getName() + " == name");
                if (obj.getName().equals(Todos.class.getName())) {
                    Todos todos = element.getAnnotation(Todos.class);
                    todosArray = todos.value();
                } else if (obj.getName().equals(Todo.class.getName())) {
                    todosArray = new Todo[1];
                    Todo todo = element.getAnnotation(Todo.class);
                    System.out.println(todo.description());
                    todosArray[0] = todo;
                }
                System.out.println("");
                System.out.println("");
                System.out.println("");
                System.out.println("==================================== TODOS ============================================ " + todosArray.length);
                for (Todo t : todosArray) {
                    if (t != null) {
                        //On récupère le contenu de l'annotation comme n'importe quel objet Java
                        System.out.println();
                        System.out.println("\t\t Auteur : " + t.auteur());
                        System.out.println("\t\t Destinataire : " + t.destinataire());
                        System.out.println("\t\t Commentaire : " + t.description());
                        System.out.println("\t\t Niveau : " + t.niveau());
                        System.out.println();
                    }
                }


            }
        }


        return true;
    }
}
