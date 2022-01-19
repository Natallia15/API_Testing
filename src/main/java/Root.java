import java.util.List;

public class Root implements ToJson {

        public long id;
        public Category category;
        public String name;
        public List<String> photoUrls;
        public List<Tag> tags;
        public String status;





        public Root(long id, Category category, String name, List<String> photoUrls, List<Tag> tags, String status) {
                this.id = id;
                this.category = category;
                this.name = name;
                this.photoUrls = photoUrls;
                this.tags = tags;
                this.status = status;
//
//                this.category.id = category.id;
//                this.category.name = category.name;
       }

    public Root() {

        }

}

