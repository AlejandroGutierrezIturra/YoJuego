package cl.ejemplo.yojuego;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter {

    List<Jugador> lista;

    public class CustomViewHolder extends RecyclerView.ViewHolder{
        TextView texto;
        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            texto=(TextView)itemView.findViewById(R.id.txtMostrar);
        }

        public void bindData(final Jugador viewModel){
            texto.setText(viewModel.toString());
        }
    }

    public CustomAdapter(List<Jugador> lista) {
        this.lista = lista;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mostrar,
                parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((CustomViewHolder)holder).bindData(lista.get(position));
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }
}


