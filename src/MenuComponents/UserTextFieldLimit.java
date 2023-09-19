package MenuComponents;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class UserTextFieldLimit extends PlainDocument {
    private int limit;

    public UserTextFieldLimit(int limit){
        this.limit = limit;
    }

    @Override
    public void insertString(int offset, String str, AttributeSet a) throws BadLocationException {
        if (str == null){
            return;
        }

        if ((getLength() + str.length()) <= limit) {
            super.insertString(offset, str, a);
        }
    }
}
