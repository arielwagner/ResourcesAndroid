import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;

public class UsersBaseAdapter extends BaseAdapter {
    Context cntxt;
    LayoutInflater lstInfltr;
    ArrayList<Users> datasCF;

    public UsersBaseAdapter() { super(); }

    public UsersBaseAdapter(Context context, ArrayList<Users> datas) {
        this.cntxt = context;
        this.datasCF = datas;
        this.lstInfltr =
            (LayoutInflater)
                this.cntxt.getSystemService(
                        Context.LAYOUT_INFLATER_SERVICE
                );
    }

    private Users getU(int position) {
        return ((Users) getItem(position));
    }

    @Override
    public int getCount() {
        return this.datasCF.size();
    }

    @Override
    public Object getItem(int position) {
        return datasCF.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = lstInfltr.inflate(R.layout.item_row_list, parent, false);
        }
        Users u = getU(position);
        TextView txt1 = (TextView) view.findViewById(R.id.txtId);
        TextView txt2 = (TextView) view.findViewById(R.id.txtContact);
        TextView txt3 = (TextView) view.findViewById(R.id.txtTelephone);
        TextView txt4 = (TextView) view.findViewById(R.id.txtEmail);
        txt1.setText(String.valueOf(u.getId()));
        txt2.setText(u.getUsername().trim());
        txt3.setText(u.getTelephone().trim());
        txt4.setText(u.getEmail().trim());
        return view;
    }
}
