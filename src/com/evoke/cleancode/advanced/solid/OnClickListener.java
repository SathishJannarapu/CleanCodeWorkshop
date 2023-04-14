package com.evoke.cleancode.advanced.solid;

import javax.swing.text.View;

/**
 * Interface definition for a callback to be invoked when a view is clicked.
 */
public interface OnClickListener {

	/**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    void onClick(View v);
}
