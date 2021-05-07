package com.smlnskgmail.jaman.checkstyle.checks;

import com.puppycrawl.tools.checkstyle.api.AbstractCheck;
import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;

import java.util.HashMap;
import java.util.Map;

public class AndroidViewFieldNameCheck extends AbstractCheck {

    private static final String MESSAGE_KEY = "AndroidViewFieldNameCheck";

    private static final Map<String, String> VIEW_NAMES = new HashMap<>();

    public AndroidViewFieldNameCheck() {
        VIEW_NAMES.put(
                "LinearLayout",
                "ll"
        );
        VIEW_NAMES.put(
                "RelativeLayout",
                "rl"
        );
        VIEW_NAMES.put(
                "ConstrainsLayout",
                "cl"
        );
        VIEW_NAMES.put(
                "FrameLayout",
                "fl"
        );
        VIEW_NAMES.put(
                "ScrollView",
                "sv"
        );
        VIEW_NAMES.put(
                "HorizontalScrollView",
                "hsv"
        );
        VIEW_NAMES.put(
                "TextView",
                "tv"
        );
        VIEW_NAMES.put(
                "ImageView",
                "iv"
        );
        VIEW_NAMES.put(
                "ImageButton",
                "ib"
        );
        VIEW_NAMES.put(
                "EditText",
                "et"
        );
        VIEW_NAMES.put(
                "Button",
                "btn"
        );
        VIEW_NAMES.put(
                "RecyclerView",
                "rv"
        );
        VIEW_NAMES.put(
                "AdaptiveRecyclerView",
                "arv"
        );
        VIEW_NAMES.put(
                "FloatingActionButton",
                "fab"
        );
        VIEW_NAMES.put(
                "ViewGroup",
                "vg"
        );
        VIEW_NAMES.put(
                "ViewPager",
                "vp"
        );
        VIEW_NAMES.put(
                "CheckBox",
                "cb"
        );
        VIEW_NAMES.put(
                "Switch",
                "sw"
        );
        VIEW_NAMES.put(
                "DrawerLayout",
                "dl"
        );
        VIEW_NAMES.put(
                "Toolbar",
                "tb"
        );
    }

    @Override
    public void visitToken(DetailAST ast) {
        DetailAST identifier = ast.findFirstToken(TokenTypes.TYPE).findFirstToken(TokenTypes.IDENT);
        if (identifier != null) {
            String fieldClassName = identifier.getText();
            if (VIEW_NAMES.containsKey(fieldClassName)) {
                String ident = ast.findFirstToken(TokenTypes.IDENT).getText();
                if (VIEW_NAMES.containsKey(fieldClassName)
                        && !ident.startsWith(VIEW_NAMES.get(fieldClassName))) {
                    log(ast);
                }
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
