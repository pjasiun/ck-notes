/**
 * @license Copyright (c) 2003-2014, CKSource - Frederico Knabben. All rights reserved.
 * For licensing, see LICENSE.md or http://ckeditor.com/license
 */

// Register a plugin named "camera".
CKEDITOR.plugins.add( 'camera', {
	lang: 'af,ar,bg,bn,bs,ca,cs,cy,da,de,el,en,en-au,en-ca,en-gb,eo,es,et,eu,fa,fi,fo,fr,fr-ca,gl,gu,he,hi,hr,hu,id,is,it,ja,ka,km,ko,ku,lt,lv,mk,mn,ms,nb,nl,no,pl,pt,pt-br,ro,ru,si,sk,sl,sq,sr,sr-latn,sv,th,tr,ug,uk,vi,zh,zh-cn', // %REMOVE_LINE_CORE%
	icons: 'camera', // %REMOVE_LINE_CORE%
	init: function( editor ) {
		editor.addCommand( 'camera', { modes: { wysiwyg: 1 },

			exec: function( editor ) {
				Camera.takePicture();
			},
			async: true
		} );

		editor.ui.addButton && editor.ui.addButton( 'Camera', {
			label: 'Camera',
			command: 'camera',
			toolbar: 'insert,10'
		} );
	}
} );

/**
 * The HTML to load in the editor when the "new page" command is executed.
 *
 *		config.camera_html = '<p>Type your text here.</p>';
 *
 * @cfg {String} [camera_html='']
 * @member CKEDITOR.config
 */
