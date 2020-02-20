package com.example.taskmaster;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.nfc.Tag;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.taskmaster.TasksFragment.OnListFragmentInteractionListener;
import com.example.taskmaster.dummy.DummyContent.DummyItem;

import java.util.List;

/**
 *
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyTasksRecyclerViewAdapter extends RecyclerView.Adapter<MyTasksRecyclerViewAdapter.ViewHolder> {

    private final List<Tasks> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MyTasksRecyclerViewAdapter(List<Tasks> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_tasks, parent, false);
        return new ViewHolder(view);
    }

    /* The following article was used to research context as used below
     https://stackoverflow.com/questions/34917808/static-viewholder-and-getting-context-when-using-with-recyclerview/34917953#34917953
     */


    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mTitleView.setText(mValues.get(position).getBody());
        holder.mBodyView.setText(mValues.get(position).getTitle());
        holder.mAssignedView.setText(mValues.get(position).getState());

        holder.mView.setOnClickListener(new View.OnClickListener() {




            // Reference - Crystal and Mattaus Helped me solve the if else logic below where it does a toast when on All-Tasks page instead of being sent to the details.

            @Override
            public void onClick(View v) {
                Context context = v.getContext();

                if (context.getClass().getName().equals("com.example.taskmaster.AllTasks")) {
                    Log.i("PETE", "-----------------" + context.getClass().getName().equals("com.example.taskmaster.AllTasks"));
                    {

                        CharSequence text =  holder.mBodyView.getText();
                        int length = Toast.LENGTH_LONG;
                        Toast renderToast = Toast.makeText(context, text, length);
                        renderToast.show();
                        renderToast.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 0);
                    }

                }

//                if(context.getClass().getName().equals"")

                else if (!context.getClass().getName().equals("com.example.taskmaster.AllTasks")) {

                    Intent sentToDetailsPage = new Intent(context, TaskDetail.class);
                    // sentToDetailsPage.putExtra("mTitleView", mTitleView);
                    sentToDetailsPage.putExtra("mTitleView", holder.mTitleView.getText());
                    sentToDetailsPage.putExtra("mBodyView", holder.mBodyView.getText());
                    sentToDetailsPage.putExtra("mAssignedView", holder.mAssignedView.getText());

                    context.startActivity(sentToDetailsPage);

                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mTitleView;
        public final TextView mBodyView;
        public final TextView mAssignedView;
        public Tasks mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mTitleView = (TextView) view.findViewById(R.id.title);
            mBodyView = (TextView) view.findViewById(R.id.body);
            mAssignedView = (TextView) view.findViewById(R.id.state);
        }

//        @Override
//        public String toString() {
//            return super.toString() + " '" + mContentView.getText() + "'";
//        }
    }
}
