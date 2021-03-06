public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    ArrayList<String> name = new ArrayList<>();
    ArrayList<String> imageUrl = new ArrayList<>();
    ArrayList<String> imageDescription = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: started.");

        initItem();

    }

    private void initItem() {
        Log.d(TAG, "initItem: preparing bitmaps.");

        imageUrl.add("https://images.unsplash.com/photo-1422393462206-207b0fbd8d6b?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&w=1000&q=80");
        name.add("New York City");
       // imageDescription.add("Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat.");

        imageUrl.add("https://images.unsplash.com/photo-1438955138287-0c090d2290d5?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&w=1000&q=80");
        name.add("Paris");


        imageUrl.add("https://images.unsplash.com/photo-1538685634737-24b83e3fa2f8?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&w=1000&q=80");
        name.add("Berlin");

        imageUrl.add("https://images.unsplash.com/photo-1532347922424-c652d9b7208e?ixlib=rb-1.2.1&w=1000&q=80");
        name.add("Summer");


        imageUrl.add("https://images.unsplash.com/photo-1557090495-fc9312e77b28?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&w=1000&q=80");
        name.add("Flower");

        initRecyClerView();
    }

    private void initRecyClerView() {
        Log.d(TAG, "initRecyClerView: init recyclerView");
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, name, imageUrl);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}
