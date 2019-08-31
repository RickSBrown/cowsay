package com.github.ricksbrown.cowsay.ant;

import com.github.ricksbrown.cowsay.plugin.CowExecutor;
import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;

/**
 * This class implements an Ant task to run cowsay.
 *
 * Usage:
 *
 * <pre>{@code
	<taskdef name="cowsay"
		classname="com.github.ricksbrown.cowsay.ant.CowsayTask"
		classpath="cowsay.jar"/>

	<cowsay message="Moo!"/>
	}</pre>
 *
 * @author Rick Brown
 */
public class CowsayTask  extends Task {
	private final CowExecutor executor = new CowExecutor();
	private String property = null;

	/**
	 *
	 * @param property Specify a property to set instead of just echoing the message.
	 */
	public void setProperty(final String property) {
		this.property = property;
	}

	/**
	 *
	 * @param cowfile Specify an alternate cowfile.
	 */
	public void setCowfile(final String cowfile) {
		executor.setCowfile(cowfile);
	}

	/**
	 *
	 * @param think If true the cow will think the message instead of saying it.
	 */
	public void setThink(final boolean think) {
		executor.setThink(think);
	}

	/**
	 *
	 * @param lang Set the i18n language.
	 */
	public void setLang(final String lang) {
		executor.setLang(lang);
	}

	/**
	 *
	 * @param alt Set the HTML alt text.
	 */
	public void setAlt(final String alt) {
		executor.setAlt(alt);
	}

	/**
	 *
	 * @param html true to turn on HTML mode.
	 */
	public void setHtml(final boolean html) {
		executor.setHtml(html);
	}

	/**
	 * @param tongue Custom tongue.
	 */
	public void setTongue(final String tongue) {
		executor.setTongue(tongue);
	}

	/**
	 * @param wrap Wrap message at approximately this length.
	 * Pass "0" for no wrap.
	 */
	public void setWrap(final String wrap) {
		executor.setWrap(wrap);
	}

	/**
	 * @param message The message for the cow to say / think.
	 */
	public void setMessage(final String message) {
		executor.setMessage(message);
	}

	/**
	 * Handle nested text.
	 * @param text The message for the cow to say / think (obtained from nested text).
	 */
	public void addText(final String text) {
		String message = getProject().replaceProperties(text);
		executor.setMessage(message);
	}
	/**
	 * @param mode The cow mode, for example "b" for "Borg".
	 */
	public void setMode(final String mode) {
		executor.setMode(mode);
	}

	/**
	 * Run cowsay with the provided attributes.
	 * @throws BuildException If something goes wrong during execution.
	 */
	@Override
	public void execute() throws BuildException {
		try {
			String moo = executor.execute();
			if (this.property != null && this.property.length() > 0) {
				getProject().setProperty(this.property, moo);
			} else {
				System.out.println(moo);
			}
		} catch (IllegalStateException ex) {
			throw new BuildException(ex.getMessage(), ex);
		}
	}
}
