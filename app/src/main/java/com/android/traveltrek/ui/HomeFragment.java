package com.android.traveltrek.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.traveltrek.BlogPost;
import com.android.traveltrek.BlogRecyclerAdapter;
import com.android.traveltrek.MyBlog;
import com.android.traveltrek.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.imaginativeworld.whynotimagecarousel.ImageCarousel;
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class HomeFragment extends Fragment {

    RecyclerView blog_post_view;
    List<MyBlog> myBlogList;
    BlogRecyclerAdapter blogRecyclerAdapter;


    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        /* Blog Posts On Home screen start*/

        blog_post_view = view.findViewById(R.id.blog_post_view);
        blog_post_view.setHasFixedSize(true);
        blog_post_view.setLayoutManager(new GridLayoutManager(getContext(),1));

        myBlogList = new ArrayList<>();
        myBlogList.add(new MyBlog("Meow","Nature","This cat is very special"));
        myBlogList.add(new MyBlog("Dog","World","This dog is very special"));
        myBlogList.add(new MyBlog("James","Tradtional","This Nature is very special"));
        blogRecyclerAdapter = new BlogRecyclerAdapter(getContext(),myBlogList);
        blog_post_view.setAdapter(blogRecyclerAdapter);

        /* ending */



        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.mapView);  //use SuppoprtMapFragment for using in fragment instead of activity  MapFragment = activity   SupportMapFragment = fragment
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap mMap) {
                mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

                mMap.clear(); //clear old markers

                CameraPosition googlePlex = CameraPosition.builder()
                        .target(new LatLng(25.276987,55.296249))
                        .zoom(1)
                        .bearing(0)
                        .tilt(45)
                        .build();

                mMap.animateCamera(CameraUpdateFactory.newCameraPosition(googlePlex), 3000, null);

                mMap.addMarker(new MarkerOptions()
                        .position(new LatLng(48.864716, 2.349014))
                        .title("Paris")
                        .snippet("Place : Eiffel-Tower")
                        .icon(BitmapDescriptorFactory.fromBitmap(createCustomMarker(getActivity(),R.drawable.paris,"Manish hotel"))));

                mMap.addMarker(new MarkerOptions()
                        .position(new LatLng(25.276987,55.296249))
                        .title("Dubai")
                        .snippet("Place : Burj AI Arab")
                        .icon(BitmapDescriptorFactory.fromBitmap(createCustomMarker(getActivity(),R.drawable.dubai,"Manish hotel"))));

                mMap.addMarker(new MarkerOptions()
                        .position(new LatLng(29.238478,76.431885))
                        .title("India")
                        .snippet("Place : Taj-Mahal")
                        .icon(BitmapDescriptorFactory.fromBitmap(createCustomMarker(getActivity(),R.drawable.india,"Manish hotel"))));

                mMap.addMarker(new MarkerOptions()
                        .position(new LatLng(39.916668,116.383331))
                        .title("China")
                        .snippet("Place : Great wall of china")
                        .icon(BitmapDescriptorFactory.fromBitmap(createCustomMarker(getActivity(),R.drawable.china,"Manish hotel"))));


                mMap.addMarker(new MarkerOptions()
                        .position(new LatLng(30.033333,	31.233334))
                        .title("USA")
                        .snippet("Place : Cairo")
                        .icon(BitmapDescriptorFactory.fromBitmap(createCustomMarker(getActivity(),R.drawable.egypt,"Manish hotel"))));
            }
        });


        ImageCarousel carousel = view.findViewById(R.id.carousel);
        carousel.registerLifecycle(getLifecycle());

        List<CarouselItem> list = new ArrayList<CarouselItem>();

        list.add(
                new CarouselItem(
                        "https://images.unsplash.com/photo-1469854523086-cc02fe5d8800?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=80",
                        ""
                )
        );

        list.add(
                new CarouselItem(
                        "https://images.unsplash.com/photo-1476514525535-07fb3b4ae5f1?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=800&q=80",
                        ""
                )
        );

        list.add(
                new CarouselItem(
                        "https://images.unsplash.com/photo-1433838552652-f9a46b332c40?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=800&q=80",
                        ""
                )
        );

        list.add(
                new CarouselItem(
                        "https://images.unsplash.com/photo-1501785888041-af3ef285b470?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=800&q=80",
                        ""
                )
        );

        list.add(
                new CarouselItem(
                        "https://images.unsplash.com/photo-1506197603052-3cc9c3a201bd?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=800&q=80",
                        ""
                )
        );


        carousel.setData(list);

        ImageCarousel carousel1 = view.findViewById(R.id.carousel1);
        carousel1.registerLifecycle(getLifecycle());

        List<CarouselItem> list1 = new ArrayList<CarouselItem>();

        list1.add(
                new CarouselItem(
                        "https://images.unsplash.com/photo-1433838552652-f9a46b332c40?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=800&q=80",
                        "Photo by Daniela Cuevas"
                )
        );

        list1.add(
                new CarouselItem(
                        "https://images.unsplash.com/photo-1476514525535-07fb3b4ae5f1?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=800&q=80",
                        "Photo by Luca Bravo"
                )
        );

        list1.add(
                new CarouselItem(
                        "https://images.unsplash.com/photo-1469854523086-cc02fe5d8800?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=80",
                        "Photo by Dino Reichmuth"
                )
        );

        list1.add(
                new CarouselItem(
                        "https://images.unsplash.com/photo-1501785888041-af3ef285b470?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=800&q=80",
                        "Photo by Pietro De Grandi"
                )
        );

        list1.add(
                new CarouselItem(
                        "https://images.unsplash.com/photo-1506197603052-3cc9c3a201bd?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=800&q=80",
                        "Photo by Drif Riadh"
                )
        );


        carousel1.setData(list1);

        return view;
    }



    public static Bitmap createCustomMarker(Context context, @DrawableRes int resource, String _name) {

        View marker = ((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.custom_marker, null);

        CircleImageView markerImage = (CircleImageView) marker.findViewById(R.id.user_dp);
        markerImage.setImageResource(resource);
        TextView txt_name = (TextView)marker.findViewById(R.id.name);
        txt_name.setText(_name);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        marker.setLayoutParams(new ViewGroup.LayoutParams(52, ViewGroup.LayoutParams.WRAP_CONTENT));
        marker.measure(displayMetrics.widthPixels, displayMetrics.heightPixels);
        marker.layout(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels);
        marker.buildDrawingCache();
        Bitmap bitmap = Bitmap.createBitmap(marker.getMeasuredWidth(), marker.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        marker.draw(canvas);

        return bitmap;
    }
    
}