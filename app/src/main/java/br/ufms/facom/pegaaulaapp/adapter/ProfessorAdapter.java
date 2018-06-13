package br.ufms.facom.pegaaulaapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.ufms.facom.pegaaulaapp.ProfessorDetalheActivity;
import br.ufms.facom.pegaaulaapp.R;
import br.ufms.facom.pegaaulaapp.bdhelper.BDHelper;
import br.ufms.facom.pegaaulaapp.model.ProfessorSubstituto;
import butterknife.ButterKnife;

public class ProfessorAdapter extends ArrayAdapter<ProfessorSubstituto> {

    BDHelper bdHelper;
    public ProfessorAdapter(@NonNull Context context, List<ProfessorSubstituto> professores) {
        super(context, R.layout.professor_item_activity ,professores);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final ViewHolder holder;
        bdHelper = new BDHelper(getContext());

        if(convertView == null){
            convertView = View.inflate(getContext(), R.layout.professor_item_activity, null);
            holder = new ViewHolder();
            ButterKnife.bind(holder, convertView);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        final ProfessorSubstituto p =  getItem(position);
        if(p!=null){
            holder.nome = convertView.findViewById(R.id.tv_nome);
            //holder.materia = convertView.findViewById();
            holder.contato = convertView.findViewById(R.id.tv_contato);
            //holder.periodo = convertView.findViewById();
            //holder.idade = convertView.findViewById();
            //holder.localizacao = convertView.findViewById();
            holder.cardView = convertView.findViewById(R.id.cardview);
            holder.img = convertView.findViewById(R.id.img_avatar);

            holder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getContext(), ProfessorDetalheActivity.class);
                    intent.putExtra("professorSubstituto", p);
                    getContext().startActivity(intent);
                }
            });
        }

        return convertView;

    }

    class ViewHolder {
        TextView nome;
        TextView materia;
        TextView contato;
        TextView periodo;
        TextView idade;
        TextView localizacao;
        CardView cardView;
        ImageView img;
    }

}
