package com.example.turtle.project_achoo.Function.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.turtle.project_achoo.Function.DownloadImageTask;
import com.example.turtle.project_achoo.Function.Model.ProductDTO;
import com.example.turtle.project_achoo.R;

import java.util.ArrayList;

public class ListviewAdapter extends BaseAdapter{

    private LayoutInflater inflater;
    private ArrayList<ProductDTO> data;
    private int layout;

    public ListviewAdapter(Context context, int layout, ArrayList<ProductDTO> data) {
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.data = data;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public String getItem(int position) {
        return data.get(position).getPname();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(layout, parent, false);
        }
        ProductDTO listviewitem = data.get(position);


        ImageView product_image = convertView.findViewById(R.id.product_image);

        new DownloadImageTask(product_image).execute(listviewitem.getPimg());

        TextView product_brand = (TextView) convertView.findViewById(R.id.product_brand);
        product_brand.setText(listviewitem.getPbrand());

        TextView product_name = (TextView) convertView.findViewById(R.id.product_name);
        product_name.setText(listviewitem.getPname());


        TextView product_price = (TextView) convertView.findViewById(R.id.product_price);
        product_price.setText(listviewitem.getPprice());

        return convertView;
    }

//    @Override
//    public Filter getFilter() {
//        return new Filter(){
//            // ContactSetGet is your gettersetter class
//
//            @Override
//            protected FilterResults performFiltering(CharSequence prefix) {
//                // TODO Auto-generated method stub
//                FilterResults results = new FilterResults();
//                List<ProductDTO> i = new ArrayList<ProductDTO>();
//               // i.addAll(data);
//
//                if (prefix!= null && prefix.toString().length() > 0) {
//
//                    for (int index = 0; index < data.size(); index++) {
//                        ProductDTO si = data.get(index);
//                        Log.d("aaaa"," "+si.getPbrand());
//                        Log.d("aaaa"," "+prefix.toString());
//                        //String number
//                        if(si.getPbrand().startsWith(prefix.toString())){
//                            i.add(si);
//                        }
//                    }
//                    results.values = i;
//                    results.count = i.size();
//                }
//                else{
//                    synchronized (data){
//                        results.values = data;
//                        results.count = data.size();
//                    }
//                }
//                return results;
//            }
//
//            @SuppressWarnings("unchecked")
//            @Override
//            protected void publishResults(CharSequence constraint,
//                                          FilterResults results) {
//                // TODO Auto-generated method stub
//                data = (ArrayList<ProductDTO>) results.values;
//                notifyDataSetChanged();
//            }
//        };
//    }
}