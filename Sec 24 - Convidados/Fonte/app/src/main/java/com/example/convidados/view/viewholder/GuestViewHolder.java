package com.example.convidados.view.viewholder;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.convidados.R;
import com.example.convidados.model.GuestModel;
import com.example.convidados.view.listener.OnListClick;

public class GuestViewHolder extends RecyclerView.ViewHolder {

    private TextView mTextName;
    private Context mContext;

    public GuestViewHolder(@NonNull View itemView) {
        super(itemView);

        // Mapeia os elementos de interface
        this.mContext = itemView.getContext();
        this.mTextName = itemView.findViewById(R.id.text_name);
    }

    /**
     * Atribui valores aos elementos de interface
     */
    public void bind(final GuestModel guest, final OnListClick listener) {

        // Atribui valor a interface
        this.mTextName.setText(guest.getName());

        // Evento de click para edição
        this.mTextName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(guest.getId());
            }
        });

        // Confirmação de remoção de usuário
        this.mTextName.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                new AlertDialog.Builder(mContext)
                        .setTitle("Remoção de convidado")
                        .setMessage("Deseja realmente remover este convidado?")
                        .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                listener.onDelete(guest.getId());
                            }
                        })
                        .setNeutralButton("Não", null)
                        .show();

                return false;
            }
        });

    }

}
