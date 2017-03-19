package eu.freedomstudio.myfirstmvp.main;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import eu.freedomstudio.myfirstmvp.main.widgets.NotesViewHolder;
import eu.freedomstudio.myfirstmvp.data.Note;

public interface MainContract {

    interface View {

        Context getAppContext();

        Context getActivityContext();

        void showToast(Toast toast);

        void showProgress();

        void hideProgress();

        void showAlert(AlertDialog dialog);

        void notifyItemRemoved(int position);

        void notifyDataSetChanged();

        void notifyItemInserted(int layoutPosition);

        void notifyItemRangeChanged(int positionStart, int itemCount);

        void clearEditText();
    }

    interface Presenter {

        void onDestroy(boolean isChangingConfiguration);

        void setView(View view);

        NotesViewHolder createViewHolder(ViewGroup parent, int viewType);

        void bindViewHolder(NotesViewHolder holder, int position);

        int getNotesCount();

        void clickNewNote(EditText editText);

        void clickDeleteNote(Note note, int adapterPos, int layoutPos);

        // dodane z innej grupy
        Context getAppContext();

        Context getActivityContext();
    }

    interface Model {
        void onDestroy(boolean isChangingConfiguration);

        int insertNote(Note note);

        boolean loadData();

        Note getNote(int position);

        boolean deleteNote(Note note, int adapterPos);

        int getNotesCount();
    }
}
