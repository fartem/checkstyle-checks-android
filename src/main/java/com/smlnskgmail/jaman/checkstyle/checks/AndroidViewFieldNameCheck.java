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
            switch (fieldClassName) {
                case "LinearLayout":
                    if (!ast.findFirstToken(TokenTypes.IDENT).getText().startsWith("lv")) {
                        log(ast);
                    }
                    break;
                case "RelativeLayout":
                    if (!ast.findFirstToken(TokenTypes.IDENT).getText().startsWith("rl")) {
                        log(ast);
                    }
                    break;
                case "ConstraintLayout":
                    if (!ast.findFirstToken(TokenTypes.IDENT).getText().startsWith("cl")) {
                        log(ast);
                    }
                    break;
                case "FrameLayout":
                    if (!ast.findFirstToken(TokenTypes.IDENT).getText().startsWith("fl")) {
                        log(ast);
                    }
                    break;
                case "ScrollView":
                    if (!ast.findFirstToken(TokenTypes.IDENT).getText().startsWith("sv")) {
                        log(ast);
                    }
                    break;
                case "HorizontalScrollView":
                    if (!ast.findFirstToken(TokenTypes.IDENT).getText().startsWith("hsv")) {
                        log(ast);
                    }
                    break;
                case "TextView":
                    if (!ast.findFirstToken(TokenTypes.IDENT).getText().startsWith("tv")) {
                        log(ast);
                    }
                    break;
                case "ImageView":
                    if (!ast.findFirstToken(TokenTypes.IDENT).getText().startsWith("iv")) {
                        log(ast);
                    }
                    break;
                case "ImageButton":
                    if (!ast.findFirstToken(TokenTypes.IDENT).getText().startsWith("ib")) {
                        log(ast);
                    }
                    break;
                case "EditText":
                    if (!ast.findFirstToken(TokenTypes.IDENT).getText().startsWith("et")) {
                        log(ast);
                    }
                    break;
                case "Button":
                    if (!ast.findFirstToken(TokenTypes.IDENT).getText().startsWith("btn")) {
                        log(ast);
                    }
                    break;
                case "RecyclerView":
                    if (!ast.findFirstToken(TokenTypes.IDENT).getText().startsWith("rv")) {
                        log(ast);
                    }
                    break;
                case "AdaptiveRecyclerView":
                    if (!ast.findFirstToken(TokenTypes.IDENT).getText().startsWith("arv")) {
                        log(ast);
                    }
                    break;
                case "FloatingActionButton":
                    if (!ast.findFirstToken(TokenTypes.IDENT).getText().startsWith("fab")) {
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
