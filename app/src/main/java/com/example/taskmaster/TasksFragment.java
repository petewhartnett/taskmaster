package com.example.taskmaster;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.amazonaws.amplify.generated.graphql.CreateTasksMutation;
import com.amazonaws.amplify.generated.graphql.CreateTodoMutation;
import com.amazonaws.amplify.generated.graphql.ListTaskssQuery;
import com.amazonaws.amplify.generated.graphql.ListTodosQuery;
import com.amazonaws.mobile.config.AWSConfiguration;
import com.amazonaws.mobileconnectors.appsync.AWSAppSyncClient;
import com.amazonaws.mobileconnectors.appsync.fetcher.AppSyncResponseFetchers;
import com.apollographql.apollo.ApolloClient;
import com.apollographql.apollo.GraphQLCall;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;
import com.example.taskmaster.dummy.DummyContent;
import com.example.taskmaster.dummy.DummyContent.DummyItem;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nonnull;

import type.CreateTasksInput;
import type.CreateTodoInput;

import static com.example.taskmaster.MainActivity.getPinpointManager;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class TasksFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */


    private AWSAppSyncClient mAWSAppSyncClient;

    public TasksFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static TasksFragment newInstance(int columnCount) {
        TasksFragment fragment = new TasksFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);



        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    public static DataBase newDB;
    public List<Tasks> listOfTasks;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tasks_list, container, false);

        mAWSAppSyncClient = AWSAppSyncClient.builder()
                .context(view.getContext().getApplicationContext())
                .awsConfiguration(new AWSConfiguration(view.getContext().getApplicationContext()))
                .build();

        //runMutation();
        runQuery();

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
          // Tasks a = new Tasks("Set alarm", "for wake up", "Assigned");

           newDB = Room.databaseBuilder(getContext(), DataBase.class, "task").allowMainThreadQueries().build();
            this.listOfTasks = newDB.taskDao().getTasks();
          // newDB.taskDao().save(a);


      recyclerView.setAdapter(new MyTasksRecyclerViewAdapter(listOfTasks, mListener));


        }
        return view;
    }


    // Taken from the aws-amplify docs -https://aws-amplify.github.io/docs/sdk/android/start

//    public void runMutation(){
//        CreateTasksInput createTasksInput = CreateTasksInput.builder().
//
//                title("test title").
//                body("test body").
//                state("test").
//                build();
//
//        mAWSAppSyncClient.mutate(CreateTasksMutation.builder().input(createTasksInput).build())
//                .enqueue(mutationCallback);
//    }
//
//    private GraphQLCall.Callback<CreateTasksMutation.Data> mutationCallback = new GraphQLCall.Callback<CreateTasksMutation.Data>() {
//
//        @Override
//        public void onResponse(@Nonnull com.apollographql.apollo.api.Response<CreateTasksMutation.Data> response) {
//
//        }
//
//        @Override
//        public void onFailure(@Nonnull ApolloException e) {
//            Log.e("Error", e.toString());
//        }
//    };



    public void runQuery(){
        mAWSAppSyncClient.query(ListTaskssQuery.builder().build())
                .responseFetcher(AppSyncResponseFetchers.CACHE_AND_NETWORK)
                .enqueue(todosCallback);
    }
//may need to change
    private GraphQLCall.Callback<ListTaskssQuery.Data> todosCallback = new GraphQLCall.Callback<ListTaskssQuery.Data>() {
        @Override
        public void onResponse(@Nonnull Response<ListTaskssQuery.Data> response) {
            Log.i("Results", response.data().listTaskss().items().toString());

            for(ListTaskssQuery.Item item : response.data().listTaskss().items() ){
                listOfTasks.add(new Tasks(item.title(), item.body(), item.state()));

            }
        }


        @Override
        public void onFailure(@Nonnull ApolloException e) {
            Log.e("ERROR", e.toString());
        }
    };





    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {

        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(DummyItem item);
    }

}
