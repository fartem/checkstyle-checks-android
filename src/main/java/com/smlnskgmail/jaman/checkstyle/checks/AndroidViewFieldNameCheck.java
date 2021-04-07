package com.smlnskgmail.jaman.checkstyle.checks;

import com.puppycrawl.tools.checkstyle.api.AbstractCheck;
import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;

public class AndroidViewFieldNameCheck extends AbstractCheck {

    private static final String MESSAGE_KEY = "AndroidViewFieldNameCheck";

    @Override
    public void visitToken(DetailAST ast) {
        DetailAST identifier = ast.findFirstToken(TokenTypes.TYPE).findFirstToken(TokenTypes.IDENT);
        if (identifier != null) {
            String fieldClassName = identifier.getText();
            String ident = ast.findFirstToken(TokenTypes.IDENT).getText();
            switch (fieldClassName) {
                case "LinearLayout":
                    if (!ident.startsWith("lv")) {
                        log(ast);
                    }
                    break;
                case "RelativeLayout":
                    if (!ident.startsWith("rl")) {
                        log(ast);
                    }
                    break;
                case "ConstraintLayout":
                    if (!ident.startsWith("cl")) {
                        log(ast);
                    }
                    break;
                case "FrameLayout":
                    if (!ident.startsWith("fl")) {
                        log(ast);
                    }
                    break;
                case "ScrollView":
                    if (!ident.startsWith("sv")) {
                        log(ast);
                    }
                    break;
                case "HorizontalScrollView":
                    if (!ident.startsWith("hsv")) {
                        log(ast);
                    }
                    break;
                case "TextView":
                    if (!ident.startsWith("tv")) {
                        log(ast);
                    }
                    break;
                case "ImageView":
                    if (!ident.startsWith("iv")) {
                        log(ast);
                    }
                    break;
                case "ImageButton":
                    if (!ident.startsWith("ib")) {
                        log(ast);
                    }
                    break;
                case "EditText":
                    if (!ident.startsWith("et")) {
                        log(ast);
                    }
                    break;
                case "Button":
                    if (!ident.startsWith("btn")) {
                        log(ast);
                    }
                    break;
                case "RecyclerView":
                    if (!ident.startsWith("rv")) {
                        log(ast);
                    }
                    break;
                case "AdaptiveRecyclerView":
                    if (!ident.startsWith("arv")) {
                        log(ast);
                    }
                    break;
                case "FloatingActionButton":
                    if (!ident.startsWith("fab")) {
                        log(ast);
                    }
                    break;
            }
        }
    }

    private void log(DetailAST ast) {
        log(ast.getLineNo(), MESSAGE_KEY);
    }

    @Override
    public int[] getDefaultTokens() {
        return getRequiredTokens();
    }

    @Override
    public int[] getAcceptableTokens() {
        return getRequiredTokens();
    }

    @Override
    public int[] getRequiredTokens() {
        return new int[] {
                TokenTypes.VARIABLE_DEF,
        };
    }

}
