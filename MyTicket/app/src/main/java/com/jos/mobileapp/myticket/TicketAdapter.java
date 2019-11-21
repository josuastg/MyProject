package com.jos.mobileapp.myticket;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TicketAdapter extends RecyclerView.Adapter<TicketAdapter.MyViewHolder>{
Context context;
ArrayList<MyTicket> myTicket;

public  TicketAdapter(Context c, ArrayList<MyTicket> p ){
    context = c;
    myTicket = p;
}

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context)
                .inflate(R.layout.item_myticket, parent, false));



}

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
    holder.xnama_wisata.setText(myTicket.get(position).getNama_wisata());
    holder.xnama_wisata.setText(myTicket.get(position).getLokasi());
    holder.xnama_wisata.setText(myTicket.get(position).getJumlah_ticket());

    final  String getNamaWisata = myTicket.get(position).getNama_wisata();
    holder.itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent gotomyticketDetails = new Intent(context, MyTicketDetail.class);
            gotomyticketDetails.putExtra("nama_wisata", getNamaWisata);
            context.startActivity(gotomyticketDetails);
        }
    });
}

    @Override
    public int getItemCount() {
        return myTicket.size(); //item berdasarkan besar my ticket
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView xnama_wisata, xjumlah_tiket, xlokasi;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            xnama_wisata = itemView.findViewById(R.id.xnama_wisata);
            xjumlah_tiket = itemView.findViewById(R.id.xjumlah_tiket);
            xlokasi = itemView.findViewById(R.id.xlokasi);
        }
    }


 }
